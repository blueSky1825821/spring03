package com.gc.action;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Interception Around通知会在JointPoint的前后执行
 * Created by sky on 16-7-11.
 */
public class LogAround implements MethodInterceptor{
    private Logger logger = Logger.getLogger(this.getClass().getName());

    //负责输出日志信息的代码
    //MethodInvocation 获得方法的名称、程序传入的参数
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        logger.log(Level.INFO, methodInvocation.getArguments()[0] + "开始审核数据...");
        try {
            //执行被调用的方法
            Object result = methodInvocation.proceed();
            //返回值既是被调用的方法的返回值
            return result;
        } finally {
            logger.log(Level.INFO, methodInvocation.getArguments()[0] + "审核数据结束...");
        }
    }
}
