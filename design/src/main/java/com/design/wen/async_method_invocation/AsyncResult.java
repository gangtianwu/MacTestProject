package com.design.wen.async_method_invocation;

import java.util.concurrent.ExecutionException;

public interface AsyncResult<T> {

    boolean complete();

    T getValue() throws ExecutionException;


    void await() throws InterruptedException;
}
