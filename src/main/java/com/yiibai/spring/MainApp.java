package com.yiibai.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sky on 2017/5/24.
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("yiibaiBean.xml");

        Student student = (Student) context.getBean("student");

        student.getName();
        student.getAge();

//        student.printThrowException();
    }
}
