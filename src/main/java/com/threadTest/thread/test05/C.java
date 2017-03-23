package com.threadTest.thread.test05;

/**
 * Created by sky on 2017/3/10.
 * 消费者
 */
public class C {
    private String lock;

    public C(String lock) {
        super();
        this.lock = lock;
    }

    public void getValue() {
        synchronized (lock) {
            if (ValueObject.value.equals("")) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("get的值是 " + ValueObject.value);
            ValueObject.value = "";
            lock.notify();
        }
    }
}
