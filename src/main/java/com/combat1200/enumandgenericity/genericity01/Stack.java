package com.combat1200.enumandgenericity.genericity01;

/**
 * Created by sky on 2017/5/22.
 * 自定义非泛型结构
 */
public class Stack {
    private Object[] container = new Object[10];
    private int index = 0;

    public void push(Object o) {
        if (index != container.length) {
            container[index++] = o; //在增加完一个元素后将指针后移一位
        }
    }

    public Object pop() {
        if (index != -1) {
            return container[--index]; //在删除完一个元素后将指针前移一位
        }
        return null;
    }

    public boolean empty() {
        if (index == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        while (!stack.empty()) {
            System.out.println((String) stack.pop());
        }
    }

}
