package com.threadTest.thread.test14;

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
        MyThreadA c = new MyThreadA(myService);
        a.setName("C");
        b.start();
        a.start();
        c.start();
    }
}
