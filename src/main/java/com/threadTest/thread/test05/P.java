package com.threadTest.thread.test05;

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
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String value = System.currentTimeMillis() + "_" + System.nanoTime();
            System.out.println("set的值是 " + value);
            lock.notify();
        }
    }
}
