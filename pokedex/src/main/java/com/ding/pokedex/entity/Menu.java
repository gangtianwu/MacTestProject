package com.ding.pokedex.entity;

import java.io.Serializable;

public class Menu implements Serializable {
    private int id;
    private String name;
    private int color;


    public Menu(int id, String name, int color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
