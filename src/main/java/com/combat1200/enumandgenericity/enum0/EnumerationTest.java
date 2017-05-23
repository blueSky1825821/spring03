package com.combat1200.enumandgenericity.enum0;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by sky on 2017/5/20.
 * 遍历枚举类型的接口
 */
public class EnumerationTest {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();    //定义一个向量保存测试用的数据
        for (int i = 0; i < 3; i++) {
            vector.add(i);
            System.out.println("在向量中增加元素： " + i);
        }
        Enumeration<Integer> elements = vector.elements();  //将向量转换成枚举类型的接口
        while (elements.hasMoreElements()) {
            System.out.println("获得向量中的元素： " + elements.nextElement());
        }
    }
}
