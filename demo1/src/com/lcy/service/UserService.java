package com.lcy.service;

import com.lcy.dao.UserDAO;

public class UserService {
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void add(){
        System.out.println("service add....");
    }

    @Override
    public String toString() {
        return "UserService{" +
                "userDAO=" + userDAO +
                '}';
    }
}
