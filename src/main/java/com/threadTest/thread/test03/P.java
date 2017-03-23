package com.threadTest.thread.test03;


/**
 * Created by sky on 2017/3/8.
 */
public class P {
    private String lock;
    public P (String lock) {
        super();
        this.lock = lock;
    }

    public void setValue() {
        synchronized (lock) {
        }
    }
}
