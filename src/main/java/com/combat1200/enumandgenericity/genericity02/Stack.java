package com.combat1200.enumandgenericity.genericity02;

import java.util.LinkedList;

/**
 * Created by sky on 2017/5/22.
 */
public class Stack<T> {
    private LinkedList<T> container = new LinkedList<T>();

    public void push(T t) {
        container.addFirst(t);  //开头插入
    }

    public T pop() {
        return container.removeFirst();
    }

    public boolean empty() {
        return container.isEmpty(); //判断链表中是否有可用元素
    }
}
