package com.lcy.dynamicproxy;

public class Person implements Sing{
    @Override
    public void sing() {
        System.out.println("Person sing!");
    }

    @Override
    public void show(String name) {
        System.out.println("Person show"+ name);
    }
}
