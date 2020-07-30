package com.example.mactestproject.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class DingLifeCycle implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void start(){

    }
}
