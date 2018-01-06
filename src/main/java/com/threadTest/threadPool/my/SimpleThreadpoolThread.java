package com.threadTest.threadPool.my;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by wm on 17-12-26.
 */
public class SimpleThreadpoolThread extends Thread{
    private AtomicBoolean execute;
    private ConcurrentLinkedQueue<Runnable> runnables;

    public SimpleThreadpoolThread(String name, AtomicBoolean execute, ConcurrentLinkedQueue<Runnable> runnables) {
        super(name);
        this.execute = execute;
        this.runnables = runnables;
    }

    @Override
    public void run() {
        while (execute.get() || runnables.isEmpty()) {
            Runnable runnable;
            while ((runnable = runnables.poll()) != null) {
                runnable.run();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.run();
    }
}
