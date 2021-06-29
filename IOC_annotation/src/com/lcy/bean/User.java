package com.lcy.bean;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
