package com.combat1200.enumandgenericity.genericity02;

/**
 * Created by sky on 2017/5/20.
 * 向栈
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
