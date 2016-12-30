package com.spring.beans;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sky on 2016/12/28.
 */

public class TestComponent {

    @Autowired
    private My my;

    @Test
    public void test01() {
        my.shout();
    }
}
