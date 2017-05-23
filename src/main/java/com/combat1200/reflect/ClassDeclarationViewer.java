package com.combat1200.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * Created by sky on 2017/5/18.
 * 查看类的说明
 */
@SuppressWarnings("")
public class ClassDeclarationViewer {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.util.ArrayList");
        System.out.println("类的标准名称： " + clazz.getCanonicalName());
        //java.lang.Class.getModifiers()这个类或接口的Java语言修饰符返回整数编码。
        // 修饰符包括public, protected, private, final, static, abstract 和interface及Java虚拟机的常数，他们应该使用Modifier类的方法进行解码。
        System.out.println("类的修饰符：" + Modifier.toString(clazz.getModifiers()));
        //输出类的泛型参数
        TypeVariable<?>[] typeVariables = clazz.getTypeParameters();
        System.out.println("类的泛型参数： ");
        if (0 != typeVariables.length) {
            for (TypeVariable<?> typeVariable : typeVariables) {
                System.out.println(typeVariable + "\t");
            }
        } else {
            System.out.println("空");
        }
        //输出类所实现的所有接口
        Type[] interfaces = clazz.getGenericInterfaces();
        System.out.println("类实现的所有接口： ");
        if (0 != interfaces.length) {
            for (Type type : interfaces) {
                System.out.println("\t" + type);
            }
        } else {
            System.out.println("\t" + "空");
        }
        //输出类的直接继承类，如果是继承自Object则返回空
        Type superClass = clazz.getSuperclass();
        System.out.println("类的直接继承类： ");
        if (null != superClass) {
            System.out.println(superClass);
        } else {
            System.out.println("空");
        }
        //输出类的所有注释信息，有些注释信息是不能用反射获得的
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println("类的注解： ");
        if (0 != annotations.length) {
            for (Annotation annotation : annotations) {
                System.out.println("\t" + annotation);
            }
        } else {
            System.out.println("空");
        }
    }
}
