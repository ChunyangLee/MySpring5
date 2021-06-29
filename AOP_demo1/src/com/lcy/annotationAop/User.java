package com.lcy.annotationAop;

import org.springframework.stereotype.Component;

@Component
public class User {

    public void add(int i, int j){
        System.out.println("add.."+(i+j));
    }
}
