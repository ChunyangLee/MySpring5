package com.lcy.bean;

public class Course {
    private String name;

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
