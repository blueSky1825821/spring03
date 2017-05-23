package com.combat1200.enumandgenericity.genericity03;

import java.lang.reflect.Array;

/**
 * Created by sky on 2017/5/22.
 */
public class GenericArray<T> {
    private T[] array;  //声明一个类为T的数组array
    private int size;

    public GenericArray(Class<T> type, int size) {
        this.size = size;
        array = (T[]) Array.newInstance(type, size);    //利用反射根据指定的类型和长度创建泛型数组
    }

    public void put(int index, T item) {
        if (size > index) {
            array[index] = item;
        }
    }

    public T get(int index) {
        if (size > index) {
            return array[index];
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("创建String类型的数组并添加元素：添加");
        GenericArray<String> stringArray = new GenericArray<>(String.class, 10);
        stringArray.put(0, "添加");
        System.out.println("String类型的数组元素：" + stringArray.get(0));

        System.out.println("创建String类型的数组并添加元素：1");
        GenericArray<Integer> integerArray = new GenericArray<>(Integer.class, 10);
        integerArray.put(0, 1);
        System.out.println("Integer类型的数组元素：" + integerArray.get(0));
    }

}
