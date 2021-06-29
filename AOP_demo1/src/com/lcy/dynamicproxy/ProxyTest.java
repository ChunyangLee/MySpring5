package com.lcy.dynamicproxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    @Test
    public void test(){
        //p是被代理对象
        Person p = new Person();
        //把p的接口传进去，把p传进去
        Sing o = (Sing)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), p.getClass().getInterfaces(), new MyInvocationHandler(p));
        o.sing();
    }

}

class MyInvocationHandler implements InvocationHandler{
    private Object o;

    public MyInvocationHandler(Object o) {
        this.o=o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //可以在这做方法的分发，不同方法名，做不同的操作。

        // 调用方法之前
        System.out.println("调用"+method.getName()+"方法之前的操作///");
        //调用被代理对象方法
        method.invoke(o, args);
        //调用方法之后
        System.out.println("调用"+method.getName()+"方法之后的操作///");
        return null;
    }

}