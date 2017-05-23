package com.combat1200.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Vector;

/**
 * Created by sky on 2017/5/19.
 * 利用反射查看方法
 */
public class Reflection {
    public static void main(String[] args) {
        Class<Vector> enumClass = Vector.class;
        String modifier = Modifier.toString(enumClass.getModifiers());
        System.out.println("enum类型的修饰符： " + modifier);
        System.out.println("enum类型的父类： " + enumClass.getSuperclass());
        System.out.println("enum类型的自定义方法： ");
        Method[] methods = enumClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
