package com.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sky on 2016/12/28.
 */
@Component("my")
public class My {
//    自动装配（autowiring）:Spring 自动将满足类型或名称的Bean注入到使用到的类
    @Autowired
    private Dog dog;

    public void shout() {
        dog.call();
    }
}
