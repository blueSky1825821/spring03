package com.threadTest.thread.test15;

/**
 * Created by sky on 2017/3/21.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        MyThreadA a = new MyThreadA(myService);
        a.setName("A");
        a.start();

        MyThreadB b = new MyThreadB(myService);
        b.setName("B");
        b.start();
        Thread.sleep(1000);

        MyThreadA c = new MyThreadA(myService);
        a.setName("C");
        c.start();
    }
}
