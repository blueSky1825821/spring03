package com.threadTest.thread.test10;

/**
 * Created by sky on 2017/3/21.
 */
public class MyThreadB extends Thread{

    private MyService myService;

    public MyThreadB(MyService service) {
        super();
        this.myService = service;
    }
    @Override
    public void run() {
        myService.awaitB();
    }
}
