package com.threadTest.thread.add.state.test01;

/**
 * Created by sky on 2017/3/23.
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread01 = new MyThread();
            System.out.println("main 方法中的状态1： " + thread01.getState());
            Thread.sleep(1000);
            thread01.start();
            Thread.sleep(1000);
            System.out.println("main 方法中的状态2： " + thread01.getState());
            MyThread thread02 = new MyThread();
            System.out.println("main 方法中的状态1： " + thread02.getState());
            Thread.sleep(1000);
            thread02.start();
            Thread.sleep(1000);
            System.out.println("main 方法中的状态2： " + thread02.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
