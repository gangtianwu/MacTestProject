package com.design.wen.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {

        ItemQueue queue = new ItemQueue();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 4; i++) {

            final Producer producer = new Producer("Producer_" + i, queue);
            executorService.submit(() -> {
                while (true) {
                    producer.produce();
                }
            });
        }

        for (int i = 0; i < 4; i++) {
            final Consumer consumer = new Consumer("Consumer_" + i, queue);
            executorService.submit(() -> {
                while (true) {
                    consumer.consume();
                }
            });
        }
        System.out.println("当前时间: shutdown前 "+System.currentTimeMillis());
        executorService.shutdown();
        try {
            System.out.println("当前时间: awaitTermination前 "+System.currentTimeMillis());
            executorService.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("当前时间: awaitTermination后 "+System.currentTimeMillis());
            executorService.shutdownNow();

        } catch (InterruptedException e) {
            System.out.println("Error waiting for ExecutorService shutdown");
        }
    }
}
