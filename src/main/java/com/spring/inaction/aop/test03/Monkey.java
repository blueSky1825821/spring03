package com.spring.inaction.aop.test03;

import org.springframework.stereotype.Component;

/**
 * Created by sky on 2017/1/17.
 */
@Component
public class Monkey implements Steal{
    @Override
    public void stealPeaches(String name){
        System.out.println("【猴子】"+name+"正在偷桃...");
    }

}
