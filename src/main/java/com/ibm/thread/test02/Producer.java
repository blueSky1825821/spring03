package com.ibm.thread.test02;

import java.util.concurrent.BlockingQueue;

/**
 * Created by sky on 2017/6/14.
 */
public class Producer implements Runnable {
    private final BlockingQueue queue;

    public Producer(BlockingQueue q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try {
            while (true) {
                queue.put(produce());
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    Object produce() {
        return new Object();
    }

}
