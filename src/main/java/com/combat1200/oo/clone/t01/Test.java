package com.combat1200.oo.clone.t01;


/**
 * 克隆
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("before");
        Employee employee1 = new Employee();
        employee1.setName("w");
        employee1.setAge(12);
        System.out.println("No.1");
        System.out.println(employee1);
        System.out.println("after");
        Employee employee2 = employee1;
        employee2.setName("m");
        employee2.setAge(114);
        System.out.println("No.2");
        System.out.println(employee2);
        System.out.println("No.1");
        System.out.println(employee1);
    }
}
