package com.design.wen.async_method_invocation;

public interface AsyncCallback<T> {
    void onComplete(T value,Exception ex);
}
