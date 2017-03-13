package com.ThreadTest.test03;


import com.sun.beans.decoder.ValueObject;

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
