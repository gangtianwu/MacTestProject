package com.design.wen.async_method_invocation;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import static java.util.Optional.*;

public class ThreadAsyncExecutor implements AsyncExecutor {
    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task) {
        return startProcess(task, null);
    }

    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> callback) {
        CompletableResult<T> tCompletableResult = new CompletableResult<>(callback);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    tCompletableResult.setValue(task.call());
                } catch (Exception e) {
                    e.printStackTrace();
                    tCompletableResult.setException(e);
                }
            }
        }).start();
        return tCompletableResult;
    }

    @Override
    public <T> T endProcess(AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException {
        if (!asyncResult.complete()){
            asyncResult.await();
        }
        return asyncResult.getValue();
    }

    private static class CompletableResult<T> implements AsyncResult<T> {

        static final int RUNNING = 1;
        static final int FAILED = 2;
        static final int COMPLETED = 3;
        volatile int state;
        Exception exception;
        T value;
        Object lock;
        final Optional<AsyncCallback<T>> callback;

        @Override
        public boolean complete() {
            return state > RUNNING;
        }


        public CompletableResult(AsyncCallback<T> callback) {
            this.lock = new Object();
            this.callback = ofNullable(callback);
        }

        @Override
        public T getValue() throws ExecutionException {
            if (state == COMPLETED) {
                return value;
            } else if (state == FAILED) {
                throw new ExecutionException(exception);
            } else {
                throw new IllegalStateException("Execution not completed yet");
            }
        }

        void setValue(T value) {
            this.value = value;
            this.state = COMPLETED;

            this.callback.ifPresent(ac -> ac.onComplete(value, null));
            synchronized (lock) {
                lock.notifyAll();
            }

        }

        void setException(Exception exception) {
            this.exception = exception;
            this.state = FAILED;
            this.callback.ifPresent(ac -> ac.onComplete(null, exception));
            synchronized (lock) {
                lock.notifyAll();
            }
        }

        @Override
        public void await() throws InterruptedException {
            synchronized (lock) {
                while (!complete()) {
                    lock.wait();
                }
            }
        }
    }
}
