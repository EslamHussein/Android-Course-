package com.suitepad.sessionone;

import java.io.Serializable;

/**
 * Created by Eslam Hussein on 3/23/18.
 */

public class Person implements Serializable {
    int id;
    String name;
    int age;
    int height;


    public Person() {
    }

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return name + " " + String.valueOf(age) + " " + String.valueOf(height);
    }
}
