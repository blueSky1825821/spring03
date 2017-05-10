package com.spring.inaction.aop.test01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by sky on 2017/1/11.
 * 观众作为切面：从演出角度观众不是核心
 */
//@Aspect
public class Audience {

    @Pointcut("execution(* com.spring.inaction.aop.test01.Performance(..))")
    public void performance(){}

    //表演之前手机静音
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silence cell phones");
    }
    //表演之前就坐
    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }
    //演出精彩鼓掌 通知方法在目标方法返回后调用
    @AfterReturning("execution(* com.spring.inaction.aop.test01.Performance(..))")
    public void applauce() {
        System.out.println("CLAP CLAP CLAP!!!");
    }
    //演出失败退费 抛出异常后调用
    @AfterThrowing("execution(* com.spring.inaction.aop.test01.Performance(..))")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
    //环绕通知
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint){
        System.out.println("Silencing cell phones");
        System.out.println("Taking seats");
        try {
            joinPoint.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("Demanding a refund");
        }
    }
}
