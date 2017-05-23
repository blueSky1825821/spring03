package com.combat1200.reflect;

import java.util.Date;

/**
 * Created by sky on 2017/5/18.
 */
public class GetClassTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("第一种方法 ： Object.getClass()");
        Class c1 = new Date().getClass();
        System.out.println(c1.getName());

        System.out.println("第二种方法 ： .Class");
        Class c2 = boolean.class;
        System.out.println(c2.getName());

        System.out.println("第三种方法 ： Class.forName()");
        Class c3 = Class.forName("java.lang.String");
        System.out.println(c3.getName());

        System.out.println("第四种方法 ： 包装类的TYPE域");
        Class c4 = Double.TYPE;
        System.out.println(c4.getName());
    }
}
