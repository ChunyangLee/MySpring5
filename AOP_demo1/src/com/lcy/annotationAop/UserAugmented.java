package com.lcy.annotationAop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAugmented {

    @Pointcut("execution(* com.lcy.annotationAop.User.add(..))")
    public void user_add_point(){}


    @Before(value = "user_add_point()")
    public void beforeMethod(){
        System.out.println("beforeMethod...");
    }
    //后置通知
    @AfterReturning("execution(* com.lcy.annotationAop.User.add(..))")
    public void afterReturning(){
        System.out.println("AfterReturning....");
    }
    @AfterThrowing("execution(* com.lcy.annotationAop.User.add(..))")
    public void afterThrowing(){
        System.out.println("AfterThrowing....");
    }
    //最终通知
    @After("execution(* com.lcy.annotationAop.User.add(..))")
    public void after(){
        System.out.println("after....");
    }
    @Around("execution(* com.lcy.annotationAop.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before....");
        proceedingJoinPoint.proceed();
        System.out.println("around after....");
    }


}
