package com.design.wen.producer_consumer;

public class Item {
    private final String producer;
    private int id;

    public Item(String producer, int id) {
        this.producer = producer;
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
