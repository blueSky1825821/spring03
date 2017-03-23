package com.threadTest.thread.test13;

/**
 * Created by sky on 2017/3/21.
 */
public class MyThreadA extends Thread{

    private MyService myService;

    public MyThreadA(MyService service) {
        super();
        this.myService = service;
    }
    @Override
    public void run() {
        myService.write();
    }
}
