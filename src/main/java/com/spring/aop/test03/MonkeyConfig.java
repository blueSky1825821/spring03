package com.spring.aop.test03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by sky on 2017/1/17.
 */
@Configuration
@EnableAspectJAutoProxy     //启用AspectJ自动代理
@ComponentScan(basePackageClasses = {Monkey.class, Guardian.class})
public class MonkeyConfig {
}
