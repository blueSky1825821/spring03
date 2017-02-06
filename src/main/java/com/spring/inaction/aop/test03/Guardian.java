package com.spring.inaction.aop.test03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by sky on 2017/1/17.
 */
@Component
@Aspect
public class Guardian {
    @Pointcut(value = "execution(* com.spring.inaction.aop.test03.Monkey.stealPeaches(..))")
    public void foundMonkey() {
    }

    @Before(value = "foundMonkey()")
    public void foundBefore() {
        System.out.println("【守护者】发现猴子正在进入果园...");
    }

    @AfterReturning(value = "foundMonkey() && args(name, ..)")
    public void foundAfter(String name) {
        System.out.println("【守护者】抓住了猴子,守护者审问出了猴子的名字叫“" + name + "”...");
    }

    @Around("foundMonkey() && args(name, ..)")
    public void watchFound(ProceedingJoinPoint joinPoint, String name) {
        System.out.println("start around" + name);
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("end around" + name);

    }


}
