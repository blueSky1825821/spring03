package com.threadTest.thread.add.state.exception;

/**
 * Created by sky on 2017/3/24.
 */
public class Main01 {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        myThread1.setName("线程t1");
        //setUncaughtExceptionHandler 对指定的线程对象设置默认的异常处理器
        myThread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("线程： " + t.getName() + " 出现异常： ");
                e.printStackTrace();
            }
        });
        myThread1.start();
        MyThread myThread2 = new MyThread();
        myThread2.setName("线程t2");
        myThread2.start();

    }


}
