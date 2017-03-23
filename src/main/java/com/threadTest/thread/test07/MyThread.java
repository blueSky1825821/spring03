package com.threadTest.thread.test07;

/**
 * Created by sky on 2017/3/21.
 */
public class MyThread implements Runnable{

    private MyService myService;

    public  MyThread(MyService service) {
        super();
        this.myService = service;
    }
    @Override
    public void run() {
        myService.testMethod();
    }
}
