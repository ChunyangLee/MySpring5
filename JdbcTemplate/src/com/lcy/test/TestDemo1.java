package com.lcy.test;

import com.lcy.bean.Book;
import com.lcy.config.TxConfig;
import com.lcy.dao.impl.AccountDAOimpl;
import com.lcy.dao.impl.BookDAOimpl;
import com.lcy.service.impl.AccountServiceimpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TxConfig.class)
public class TestDemo1 {
    @Autowired
    private AccountServiceimpl accountServiceimpl;

    @Test
    public void test5(){
        accountServiceimpl.transfer(1,2,600);
    }

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        BookDAOimpl bdi = context.getBean("bookDAOimpl", BookDAOimpl.class);
        bdi.add(new Book());
    }
    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        AccountServiceimpl as = context.getBean("accountServiceimpl", AccountServiceimpl.class);
        as.transfer(1,2,500);
    }

    @Test
    public void test3(){
        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(TxConfig.class);
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        AccountServiceimpl as = context1.getBean("accountServiceimpl", AccountServiceimpl.class);
        as.transfer(1,2,500);
    }
}
