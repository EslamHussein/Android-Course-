package com.suitepad.sessionone;

import java.io.Serializable;

/**
 * Created by Eslam Hussein on 3/23/18.
 */

public class Person implements Serializable {
    String name;
    int age;
    int h;


    public Person(String name, int age, int h) {
        this.name = name;
        this.age = age;
        this.h = h;
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

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    @Override
    public String toString() {
        return name + " " + String.valueOf(age) + " " + String.valueOf(h);
    }
}
