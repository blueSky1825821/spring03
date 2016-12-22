package com.gc.action;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sky on 16-7-13.
 */
//After Returning通知只在JointPoint的后面执行
public class LogAfter implements AfterReturningAdvice {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    //实现After Returning 通知的类需要实现接口AfterReturningAdvice
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        logger.log(Level.INFO, objects[0] + "审核数据完成...");
    }

}
