package com.threadTest.thread.add.state.test01;


/**
 * Created by sky on 2017/3/23.
 */
public class MyThread extends Thread {
    public MyThread() {
        try {
            System.out.println("构造方法中的状态1： " + Thread.currentThread().getState());
            Thread.sleep(1000);
            System.out.println("构造方法中的状态2： " + Thread.currentThread().getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("run 构造方法中的状态1： " + Thread.currentThread().getState());
            Thread.sleep(1000);
            try {
                synchronized (Lock.lock) {
                    Thread.sleep(1000);
                    Lock.lock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run 构造方法中的状态2： " + Thread.currentThread().getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
