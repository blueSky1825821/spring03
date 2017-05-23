package com.combat1200.reflect;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by sky on 2017/5/19.
 */
public class Agency implements InvocationHandler {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Object delegate;

    //绑定代理对象
    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理人员在卖房子");
        Object result = null;
        try {
            result = method.invoke(delegate, args);
        } catch (Exception e) {
            System.out.println("invoke error!");
        }
        return result;
    }

    public static void main(String[] args) {
        Seller seller = new HouseSeller();
        System.out.println("不使用代理方式： ");
        seller.sell();
        System.out.println("使用代理方式： ");
        seller = (Seller) new Agency().bind(seller);
        seller.sell();
    }
}
