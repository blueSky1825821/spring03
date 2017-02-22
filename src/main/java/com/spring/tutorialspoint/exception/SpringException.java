package com.spring.tutorialspoint.exception;

/**
 * Created by sky on 2016/12/23.
 */
public class SpringException extends RuntimeException{
    private String exceptionMsg;

    public SpringException(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionMsg(){
        return this.exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
