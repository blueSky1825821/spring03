package com.ThreadTest.test01;

/**
 * Created by sky on 2017/3/8.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }
}
