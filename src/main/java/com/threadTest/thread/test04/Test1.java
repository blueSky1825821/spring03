package com.threadTest.thread.test04;

/**
 * Created by sky on 2017/3/9.
 */
public class Test1 {
    public static void main(String[] args) {
        String lock = new String();
        System.out.println("syn 第一行 ");
        try {
            lock.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("syn 下面的代码 ");
    }
}
