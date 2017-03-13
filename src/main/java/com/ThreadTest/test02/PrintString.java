package com.ThreadTest.test02;

/**
 * Created by sky on 2017/3/8.
 */
public class PrintString implements Runnable {
    //volatile当线程访问isRunning这个变量，强制性从公共堆栈中进行取值
    //volatile解决多个线程之间的可见性，synchronized解决多个线程之间访问的可见性
    volatile private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void printStringMethod() {
        while (true == isContinuePrint) {
            System.out.println("run printStirngMethod threadName = " +
                    Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        printStringMethod();
    }
}
