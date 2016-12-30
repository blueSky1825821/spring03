package com.spring.beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sky on 2016/12/28.
 */
@Configuration
//@ComponentScan(basePackages = "com.spring.*")
@ComponentScan(basePackageClasses = {Dog.class, My.class})
public class Myconfig {

}
