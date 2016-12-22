package com.spring.advice.net;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by sky on 16-7-10.
 */
public class LogBeforeAdvice implements MethodBeforeAdvice{

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("开始审核数据...");
    }

}
