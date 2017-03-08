package com.oknesif.android_mvp.list.objects;

public class Entity {
    private final int id;
    private final String name;
    private final int age;


    public Entity(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
}
