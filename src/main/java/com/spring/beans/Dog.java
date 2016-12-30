package com.spring.beans;

import org.springframework.stereotype.Component;

/**
 * Created by sky on 2016/12/28.
 */
//组建扫描（component scanning）:Spring 会自动发现应用上下文中所创建的bean
@Component
public class Dog {
    public void call() {
        System.out.println("汪汪。。。");
    }
}
