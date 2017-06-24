package com.ibm.thread.test02;

import java.util.concurrent.BlockingQueue;

/**
 * Created by sky on 2017/6/14.
 */
public class Consumer implements Runnable {
    private final BlockingQueue queue;

    public Consumer(BlockingQueue q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try {
            while (true) {
                consume(queue.take());
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    void consume(Object o) {

    }
}
