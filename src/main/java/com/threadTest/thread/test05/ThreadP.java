package com.threadTest.thread.test05;

import com.threadTest.thread.test04.MyList;

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
