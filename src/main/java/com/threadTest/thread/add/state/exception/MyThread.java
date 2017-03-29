package com.threadTest.thread.add.state.exception;

/**
 * Created by sky on 2017/3/24.
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        String username = null;
        //NullPointerException
        System.out.println(username.hashCode());
    }
}
