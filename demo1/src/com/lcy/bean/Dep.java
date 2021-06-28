package com.lcy.bean;

public class Dep {
    private String name;

    @Override
    public String toString() {
        return "Dep{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public Dep() {
        System.out.println("dep 空参构造器");
    }

    public void setName(String name) {
        System.out.println("dep setName"+name);
        this.name = name;
    }
    public void init(){
        System.out.println("dep init!");
    }

    public void destroy(){
        System.out.println("dep destroy");
    }
}
