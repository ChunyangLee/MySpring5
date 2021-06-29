package com.lcy.spring5;

import com.alibaba.druid.pool.DruidDataSource;
import com.lcy.bean.Course;
import com.lcy.bean.Emp;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo2 {
    @Test
    public void testFactoryBean(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("factorybean.xml");
        Course mybean = context.getBean("mybean", Course.class);
        // <bean id="mybean" class="com.lcy.factorybean.MyBean"></bean>
        System.out.println(mybean);

    }
    @Test
    public void test_bean_progress(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);

    }

    @Test
    public void test_druid(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("connection_pool.xml");
        DruidDataSource source = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(source);

    }
}
