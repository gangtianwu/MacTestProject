package com.design.wen.async_method_invocation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class App {
    public static void main(String[] args) {
        ThreadAsyncExecutor threadAsyncExecutor = new ThreadAsyncExecutor();
        AsyncResult<Integer> result1 = threadAsyncExecutor.startProcess(lazyval(10, 500));
        AsyncResult<String> result2 = threadAsyncExecutor.startProcess(lazyval("test", 300));
        AsyncResult<Long> result3 = threadAsyncExecutor.startProcess(lazyval(50L, 700));
        AsyncResult<Integer> result4 = threadAsyncExecutor.startProcess(lazyval(20, 400), callback("Callback result 4"));
        AsyncResult<String> result5 = threadAsyncExecutor.startProcess(lazyval("callback", 600), callback("Callback result 5"));

        try {
            Thread.sleep(350);

        System.out.println("some hard work done");

        threadAsyncExecutor.endProcess(result1);
        threadAsyncExecutor.endProcess(result2);
        threadAsyncExecutor.endProcess(result3);
        result4.await();
        result5.await();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Result 3: " + result3);

    }


    private static <T> Callable<T> lazyval(T value, long delayMillis) {
        return () -> {
            Thread.sleep(delayMillis);
            System.out.println("Task completed with: " + value);
            return value;
        };
    }

    private static <T> AsyncCallback<T> callback(String name) {
        return (value, ex) -> {
            if (ex != null) {
                System.out.println(name + " failed: " + ex.getMessage());
            } else {
                System.out.println(name + ": " + value);
            }
        };
    }
}
