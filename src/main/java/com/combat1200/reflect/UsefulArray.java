package com.combat1200.reflect;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sky on 2017/5/19.
 * 创建可变长数组
 */
public class UsefulArray {
    public static Object increaseArray(Object array) {
        Class<?> clazz = array.getClass();  //获得代表数组的class对象
        if (clazz.isArray()) {  //是数组
            Class<?> componentType = clazz.getComponentType();  //获取数组元素的类型
            int length = Array.getLength(array);
            Object newArray = Array.newInstance(componentType, length + 5); //新建数组
            System.arraycopy(array, 0, newArray, 0, length);    //复制原来数组中的所有数据
            return newArray;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] intArray = new int[10];
        System.out.println("整型数组原始长度是： " + intArray.length);
        Arrays.fill(intArray, 8);   //将数组元素赋值8
        System.out.println("整型数组内容： ");
        System.out.println(Arrays.toString(intArray));
        int[] newIntArray = (int[]) increaseArray(intArray);
        System.out.println("扩展后的整型数组原始长度是： " + newIntArray.length);
        System.out.println("扩展后的整型数组： ");
        System.out.println(Arrays.toString(newIntArray));
    }
}
