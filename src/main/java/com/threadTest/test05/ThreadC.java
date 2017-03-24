package com.threadTest.test05;

/**
 * Created by sky on 2017/3/9.
 */
public class ThreadC extends Thread{
    private C c;
    public ThreadC(C c) {
        super();
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.getValue();
        }
    }
}
