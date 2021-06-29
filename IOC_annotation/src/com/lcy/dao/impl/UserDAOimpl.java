package com.lcy.dao.impl;

import com.lcy.dao.UserDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOimpl implements UserDAO {
    @Value("defaultName")
    private String name;

    @Value("13")
    private double number;

    @Override
    public String toString() {
        return "UserDAOimpl{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }


    @Override
    public void update() {

        System.out.println("dao update.....");
    }
}
