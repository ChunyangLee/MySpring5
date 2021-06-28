package com.lcy.spring5;

import com.lcy.bean.CollectionInjection;
import com.lcy.bean.Dep;
import com.lcy.bean.Emp;
import com.lcy.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println(order);
    }
    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
    }
    @Test
    public void test_ref_bean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
//        内部bean， 不能获得里面嵌套的，
        //外部bean，级联赋值可以用，
        Dep dep = context.getBean("dep", Dep.class);
        System.out.println(dep);
    }
    @Test
    public void test_innerBeanInject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Dep dep = context.getBean("dep", Dep.class);
        System.out.println(dep);

        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
//        内部bean， 不能获得里面嵌套的，
        //外部bean，级联赋值可以用，
    }
    @Test
    public void testCollectionInject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("collectionInject.xml");
        CollectionInjection collection = context.getBean("collection", CollectionInjection.class);
        System.out.println(collection);

        //false,
        System.out.println(collection.getList().get(0) instanceof Integer);
    }
    @Test
    public void testExtractCommon(){
        ApplicationContext context = new ClassPathXmlApplicationContext("extractCommon.xml");
        CollectionInjection collection2 = context.getBean("collection2", CollectionInjection.class);
        System.out.println(collection2.getList());
    }

}

