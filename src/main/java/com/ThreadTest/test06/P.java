package com.ThreadTest.test06;

/**
 * Created by sky on 2017/3/10.
 * 生产者
 */
public class P {
    private String lock;
    public P(String lock) {
        super();
        this.lock = lock;
    }
    public void setValue() {
        synchronized (lock) {
            if (!ValueObject.value.equals("")) {
                try {
                    System.out.println("生产者" + Thread.currentThread().getName() + "WAITING");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("生产者 " + Thread.currentThread().getName() + "RUNNING");
            String value = System.currentTimeMillis() + "_" + System.nanoTime();
            ValueObject.value = value;
            lock.notify();
        }
    }
}
