package com.spring.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by sky on 16-7-10.
 */
public class LogAfterAdvice implements AfterReturningAdvice{

    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("审核数据结束...");
    }
}
