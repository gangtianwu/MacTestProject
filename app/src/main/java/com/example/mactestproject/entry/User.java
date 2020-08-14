package com.example.mactestproject.entry;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -8708963825136523098L;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
