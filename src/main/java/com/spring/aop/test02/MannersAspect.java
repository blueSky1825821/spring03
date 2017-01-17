package com.spring.aop.test02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by sky on 2017/1/16.
 */
@Aspect
public class MannersAspect {
    @Before("execution(* com.spring.aop.test02.HelloWorld.deliver(..))")
    public void deliverMessage() {
        System.out.println("before!");
    }

    @After("execution(* com.spring.aop.test02.HelloWorld.deliver(..))")
    public void afterMessage() {
        System.out.println("after!");
    }

    @Around("execution(* com.spring.aop.test02.HelloWorld.round(s)) && args(s)")
    public void around(String s) {
        System.out.println("around before!");
//        proceed("99 "+s+" 00 ");
        System.out.println("around after! ");
    }
}
