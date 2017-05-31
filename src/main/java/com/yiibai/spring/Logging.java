package com.yiibai.spring;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by sky on 2017/5/24.
 */
@Aspect
public class Logging {
    private static Logger logger = Logger.getLogger(Logging.class);

    /**
     * Following is the definition for a pointcut to select
     * all the methods available. So advice will be called
     * for all the methods.
     */
    @Pointcut("execution(* com.yiibai.spring.*.*(..))")
    private void selectAll() {
    }

    @Pointcut("execution(* com.yiibai.spring.Student.getName(..))")
    private void selectGetName() {
    }

    @Pointcut("execution(* com.yiibai.spring.Student.getAge(..))")
    private void selectGetAge() {
    }

    @Before("selectAll()")
    public void beforeAdvice() {
        logger.error("[beforeAdvice] Going to setup student profile.");
    }

    @Before("selectGetName()")
    public void beforeGetNameAdvice() {
        logger.error("[beforeGetNameAdvice] Going to setup student profile.");
    }

    @After("selectGetAge()")
    public void afterGetAdvice() {
        logger.error("[afterGetAdvice] Going to setup student profile.");
    }

    /**
     * @param jp     execution内容
     * @param retVal 方法返回的对象
     */
//    @AfterReturning(pointcut = "execution(* com.yiibai.spring.Student.*(..))", returning = "retVal")
//    public void afterReturningAdvice(JoinPoint jp, Object retVal) {
//        logger.error("[afterReturningAdvice] Method Signature: " + jp.getSignature());
//        logger.error("[afterReturningAdvice] Returning: " + retVal.toString());
//    }

    /**
     * This is the method which I would like to execute
     * after a selected method execution throws exception.
     */
//    @AfterThrowing(pointcut = "execution(* com.yiibai.spring.Student.*(..))", throwing = "error")
//    public void afterThrowingAdvice(JoinPoint jp, Throwable error) {
//        System.out.println("[afterThrowingAdvice] Method Signature: " + jp.getSignature());
//        System.out.println("[afterThrowingAdvice] Exception: " + error);
//    }

    /**
     * This is the method which I would like to execute
     * around a selected method execution.
     */
    @Around("selectGetAge()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.error("Around advice");
        Object[] args = proceedingJoinPoint.getArgs();
        if (args.length > 0) {
            logger.error("Arguments passed: ");
            for (int i = 0; i < args.length; i++) {
                logger.error("arg " + (i + 1) + ": " + args[i]);
            }
        }

        Object result = proceedingJoinPoint.proceed(args);
        logger.error("Returning " + result);
    }
}
