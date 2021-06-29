package com.lcy.test;

import com.lcy.annotationAop.MyConfig;
import com.lcy.annotationAop.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo1 {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop1.xml");
        User user = context.getBean("user", User.class);
        user.add(1, 2 );
    }

    @Test
    public void test_pure_annotation(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User user = context.getBean("user", User.class);
        user.add(1, 2 );
    }

    //xml配置中可以通过 <context:annotation-config/>使用Config类中的创建的bean
    @Test
    public void test3(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
    }

}
