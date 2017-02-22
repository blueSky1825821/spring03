package com.spring.advice;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.remoting.support.RemoteExporter;

/**
 * Created by sky on 16-7-10.
 */
public class LogThrowAdvice implements ThrowsAdvice{
    public void afterThrowing (RemoteExporter remoteExporter) throws Throwable{
        System.out.println("审核数据抛出异常...");
    }
}
