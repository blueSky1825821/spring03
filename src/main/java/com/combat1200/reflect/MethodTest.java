package com.combat1200.reflect;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by sky on 2017/5/18.
 * 动态调用类中的方法
 */
public class MethodTest {
    public static void main(String[] args) {
        try {
            System.out.println("调用Math类的静态方法sin()");
            Method sin = Math.class.getDeclaredMethod("sin", Double.TYPE);
            Double sin1 = (Double) sin.invoke(null, new Integer(1));
            System.out.println("1的正弦值是： " + sin1);
            System.out.println("调用String类的非静态方法 equals()");
            Method equals = String.class.getDeclaredMethod("equals", Object.class);
            Boolean mrsoft = (Boolean) equals.invoke(new String("明日"), "明日");
            System.out.println("字符串是否是 明日：" + mrsoft);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
