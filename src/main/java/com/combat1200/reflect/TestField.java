package com.combat1200.reflect;

import com.gc.action.Student;

import java.lang.reflect.Field;

/**
 * Created by sky on 2017/5/18.
 * 动态设置类的私有域
 */
public class TestField {
    public static void main(String[] args) {
        Student student = new Student();
        Class<? extends Student> clazz = student.getClass();
        System.out.println("类的标准名称： " + clazz.getCanonicalName());
        try {
            Field id = clazz.getDeclaredField("id");
            System.out.println("设置前的id： " + student.getId());
            //对于私有域，一定要使用setAccessible(true)将可见性设置为true才能设置新值
            id.setAccessible(true);
            id.set(student, "10");
            System.out.println("设置后的id： " + student.getId());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
