package com.spring.tutorialspoint.www;

/**
 * Created by sky on 2016/12/12.
 */
public class HelloIndia {
    private String message;
    private String message1;
    private String message2;
    private String message3;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessage1(String message){
        this.message1  = message;
    }

    public void setMessage2(String message){
        this.message2  = message;
    }

    public void setMessage3(String message){
        this.message3  = message;
    }

    public void getMessage1(){
        System.out.println("India Message1 : " + message1);
    }

    public void getMessage2(){
        System.out.println("India Message2 : " + message2);
    }

    public void getMessage3(){
        System.out.println("India Message3 : " + message3);
    }

    public void init(){
        System.out.println("Bean is going through init.");
    }
    public void destroy(){
        System.out.println("Bean will destroy now.");
    }
}
