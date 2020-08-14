package com.design.wen.producer_consumer;

import java.util.Random;

public class Producer {
    private static final Random RANDOM = new Random();

    private final ItemQueue queue;

    private final String name;

    private int itemId;

    public Producer(String name, ItemQueue queue) {
        this.name = name;
        this.queue = queue;
    }

    /**
     * Put item in the queue.
     */
    public void produce() throws InterruptedException {

        Item item = new Item(name, itemId++);
        queue.put(item);
        System.out.println("当前线程: "+ Thread.currentThread().getName() + "生产者名称: "+ name + " 成品ID: "+ itemId);
        Thread.sleep(RANDOM.nextInt(2000));
    }
}
