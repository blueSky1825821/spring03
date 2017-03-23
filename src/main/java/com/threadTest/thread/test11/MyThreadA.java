package com.threadTest.thread.test11;

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
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            myService.set();
        }
    }
}
