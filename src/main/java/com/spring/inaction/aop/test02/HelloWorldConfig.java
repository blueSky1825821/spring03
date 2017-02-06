package com.spring.inaction.aop.test02;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by sky on 2017/1/16.
 */
@Configuration
@EnableAspectJAutoProxy     //启用AspectJ自动代理
@ComponentScan
public class HelloWorldConfig {

}
