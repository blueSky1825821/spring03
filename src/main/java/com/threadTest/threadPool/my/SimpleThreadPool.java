package com.threadTest.threadPool.my;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wm on 17-12-26.
 */
public class SimpleThreadPool {
    //count of threadpools created
    private static AtomicInteger poolCount = new AtomicInteger(0);
    //Queue of runnables
    private ConcurrentLinkedQueue<Runnable> runnables;
    //Flag to control the simplethreadpoolthread objects
    private AtomicBoolean execute;
    //Holds the pool of thread
    private List<SimpleThreadpoolThread> threads;

    private class ThreadpoolException extends RuntimeException {
        public  ThreadpoolException(Throwable cause) {
            super(cause);
        }
    }


}
