package com.threadTest.thread.test07;

/**
 * Created by sky on 2017/3/21.
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThread a1 = new MyThread(myService);
        MyThread a2 = new MyThread(myService);
        MyThread a3 = new MyThread(myService);
        MyThread a4 = new MyThread(myService);
        MyThread a5 = new MyThread(myService);
        a1.run();
        a2.run();
        a3.run();
        a4.run();
        a5.run();
    }
}
