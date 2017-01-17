package com.spring.aop.test03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sky on 2017/1/17.
 */
//测试时自动创建Spring应用上下文
@RunWith(SpringJUnit4ClassRunner.class)
//加载bean
@ContextConfiguration(classes = MonkeyConfig.class)
public class Test03 {
    @Autowired Steal monkey;

    @Test
    public void test01() {
        monkey.stealPeaches("孙大圣的大徒弟");
    }
}
