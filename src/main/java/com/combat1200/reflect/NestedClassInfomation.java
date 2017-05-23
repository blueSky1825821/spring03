package com.combat1200.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * Created by sky on 2017/5/18.
 */
public class NestedClassInfomation {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.awt.geom.Path2D");
        Class<?>[] classes = cls.getDeclaredClasses();
        for (Class<?> clazz : classes) {
            System.out.println("类的标准名称： " + clazz.getCanonicalName());
            System.out.println("类的修饰符： " + Modifier.toString(clazz.getModifiers()));
            Type[] interfaces = clazz.getGenericInterfaces();
            System.out.println("类所实现的接口： ");
            if (0 != interfaces.length) {
                for (Type type: interfaces) {
                    System.out.println("\t" + type);
                }
            } else {
                System.out.println("空");
            }
            Type superClass = clazz.getGenericSuperclass();
            System.out.println("类的直接继承类： ");
            if (null != superClass) {
                System.out.println(superClass);
            } else {
                System.out.println("空");
            }
        }

    }
}
