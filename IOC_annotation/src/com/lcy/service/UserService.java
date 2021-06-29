package com.lcy.service;

import com.lcy.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.annotation.Retention;

//@Component(value = "userService")
//@Component("userService")
@Service
public class UserService {
//    @Autowired
//    @Qualifier("userDAOimpl")
      @Resource(name = "userDAOimpl")
    private UserDAO userDAO;

    @Override
    public String toString() {
        return "UserService{" +
                "userDAO=" + userDAO +
                '}';
    }
}
