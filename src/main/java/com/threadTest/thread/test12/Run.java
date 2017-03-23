package com.threadTest.thread.test12;

/**
 * Created by sky on 2017/3/21.
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThreadA a = new MyThreadA(myService);
        a.setName("A");
        MyThreadB b = new MyThreadB(myService);
        b.setName("B");
        a.start();
        b.start();
    }
}
