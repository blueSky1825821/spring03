package com.spring.inaction.aop.test01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by sky on 2017/1/11.
 */
//@Configuration
//@EnableAspectJAutoProxy     //启用AspectJ自动代理
//@ComponentScan
public class ConcertConfig {

    @Bean
    public Audience audience() {    //声明Audience Bean
        return new Audience();
    }
}
