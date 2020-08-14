package com.design.wen.producer_consumer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ItemQueue {
    private BlockingQueue<Item> queue;

    public ItemQueue() {
        this.queue = new LinkedBlockingDeque<>();
    }
    public void put(Item item) throws InterruptedException {
        queue.put(item);
    }
    public Item take() throws InterruptedException {
        return queue.take();
    }
}
