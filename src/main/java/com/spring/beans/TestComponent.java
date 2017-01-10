package com.spring.beans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sky on 2016/12/28.
 */

//测试时自动创建Spring应用上下文
@RunWith(SpringJUnit4ClassRunner.class)
//加载bean
@ContextConfiguration(classes = Myconfig.class)
public class TestComponent {

    @Autowired
    private My my;

    @Test
    public void test01() {
        my.shout();
    }

}
