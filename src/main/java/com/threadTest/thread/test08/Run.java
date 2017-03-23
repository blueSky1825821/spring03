package com.threadTest.thread.test08;

/**
 * Created by sky on 2017/3/21.
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThreadA a1 = new MyThreadA(myService);
        MyThreadA a2 = new MyThreadA(myService);
        MyThreadA a3 = new MyThreadA(myService);
        MyThreadA a4 = new MyThreadA(myService);
        MyThreadA a5 = new MyThreadA(myService);
        a1.run();
        a2.run();
        a3.run();
        a4.run();
        a5.run();
    }
}
