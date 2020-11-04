package com.design.wen.pipeline;

import java.util.concurrent.Semaphore;

public class FooBar {
    int n;
    Semaphore semaphore1 = new Semaphore(0);
    Semaphore semaphore2 = new Semaphore(1);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(){
        for (int i = 0; i < n; i++) {
            try {
                semaphore1.acquire();
                System.out.println("foo method---> ");
                semaphore2.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void bar(){
        for (int i = 0; i < n; i++) {
            try {
                semaphore2.acquire();
                System.out.println("bar method--->");
                semaphore1.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
