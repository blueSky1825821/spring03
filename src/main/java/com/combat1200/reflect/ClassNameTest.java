package com.combat1200.reflect;

import java.util.Date;

/**
 * Created by sky on 2017/5/18.
 * 获得Class对象表示的实体名称
 */
public class ClassNameTest {
    public static void main(String[] args) {
        String dateName = Date.class.getName();
        System.out.println("非数组引用类型的名称：" + dateName);

        String byteName = byte.class.getName();
        System.out.println("基本类型的名称：" + byteName);

        String oneDimensionArray = Date[].class.getName();
        System.out.println("一维引用类型数组：" + oneDimensionArray);

        String twoDimensionArray = Date[][].class.getName();
        System.out.println("一维引用类型数组：" + twoDimensionArray);
    }
}
