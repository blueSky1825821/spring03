package com.threadTest.thread.test06;

/**
 * Created by sky on 2017/3/9.
 */
public class ThreadP extends Thread{
    private P p;
    public ThreadP(P p) {
        super();
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }
}
