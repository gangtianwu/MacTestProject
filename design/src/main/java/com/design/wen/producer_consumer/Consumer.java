package com.design.wen.producer_consumer;

public class Consumer {

    private final ItemQueue queue;

    private final String name;

    public Consumer(String name, ItemQueue queue) {
        this.name = name;
        this.queue = queue;
    }

    /**
     * Consume item from the queue.
     */
    public void consume() throws InterruptedException {
        Item item = queue.take();
        System.out.println("当前线程: "+Thread.currentThread().getName()+" Consumer "+ name+" +consume item "+item.getId()+" produced by "+item.getProducer());
    }
}
