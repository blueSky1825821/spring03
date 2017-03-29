package com.threadTest.thread.add.state.exception;

/**
 * Created by sky on 2017/3/24.
 */
public class Main02 {
    public static void main(String[] args) {
        //setDefaultUncaughtExceptionHandler 为指定线程类的所有线程对象设置默认的异常处理器
        MyThread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("线程： " + t.getName() + " 出现异常： ");
                e.printStackTrace();
            }
        });
        MyThread myThread1 = new MyThread();
        myThread1.setName("线程t1");
        myThread1.start();
        MyThread myThread2 = new MyThread();
        myThread2.setName("线程t2");
        myThread2.start();
    }
}
