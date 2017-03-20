package com.ThreadTest.test06;

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
            while (ValueObject.value.equals("")) {
                try {
                    System.out.println("消费者 " + Thread.currentThread().getName() + "WAITING");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费者 " + Thread.currentThread().getName() + "RUNNING");
            ValueObject.value = "";
            lock.notify();
        }
    }
}
