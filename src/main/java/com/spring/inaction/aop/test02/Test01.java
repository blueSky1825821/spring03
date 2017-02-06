package com.spring.inaction.aop.test02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sky on 2017/1/16.
 */
//测试时自动创建Spring应用上下文
@RunWith(SpringJUnit4ClassRunner.class)
//加载bean
@ContextConfiguration(classes = HelloWorldConfig.class)
public class Test01 {
    @Autowired HelloWorld helloWorld;

    @Test
    public void test01() {

        helloWorld.deliver("Wanna learn AspectJ?");
        helloWorld.deliver("Harry", "having fun?");
        helloWorld.round("round");
    }
}
