package com.spring.inaction.aop.test02;

import org.springframework.stereotype.Component;

/**
 * Created by sky on 2017/1/16.
 */
@Component("helloWorld")
public class HelloWorld {
    public static void deliver(String message) {
        System.out.println(message);
    }

    public static void deliver(String person, String message) {
        System.out.println(person + ", " + message);
    }

    public static void round(String s){
        System.out.println(s);
    }
}
