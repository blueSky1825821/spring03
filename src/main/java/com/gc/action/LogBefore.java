package com.gc.action;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sky on 16-7-11.
 */
public class LogBefore implements MethodBeforeAdvice {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    //Before通知只在JointPoint前面执行
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        logger.log(Level.INFO, objects[0] + "开始审核数据...");
    }
}
