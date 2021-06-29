package com.lcy.annotationAop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class UserAug2 {

//    @Pointcut("execution(* com.lcy.annotationAop.User.add(..))")
//    public void user_add_point(){}

    @Before("com.lcy.annotationAop.UserAugmented.user_add_point()")
    public void before(){
        System.out.println("UserAug2 before....");
    }
}
