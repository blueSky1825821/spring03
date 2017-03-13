package com.test.test;

import org.junit.Test;

import java.util.Vector;

/**
 * Created by sky on 2017/1/5.
 */
public class Test01 {
    public static void main(String[] args) {
        String s = String.valueOf(Double.parseDouble("10") / 100);
        System.out.println(s);
    }

    @Test
    public void test01() {
        Vector v = new Vector();
        for (int i = 0; i < 100; i++) {
            Object o = new Object();
            v.add(o);
            o = null;
        }
    }
}
