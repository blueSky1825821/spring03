package com.spring.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by sky on 16-7-10.
 */
public class LogInterceptor implements MethodInterceptor{

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("开始审核数据...");
        Object rval = methodInvocation.proceed();
        System.out.println("审核数据结束...");
        return rval;
    }

}
