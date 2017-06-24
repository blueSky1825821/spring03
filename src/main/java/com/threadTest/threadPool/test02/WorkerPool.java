package com.threadTest.threadPool.test02;

import com.threadTest.threadPool.test01.WorkerThread;

import java.util.concurrent.*;

/**
 * Created by sky on 2017/6/16.
 */
public class WorkerPool {
    public static void main(String[] args) {
        RejectExecutionHandlerImpl rejectExecutionHandler = new RejectExecutionHandlerImpl();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectExecutionHandler);
        MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();
        for (int i = 0; i < 10; i++) {
            executorPool.execute(new WorkerThread("cmd" + i));
        }
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorPool.shutdown();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.shutdown();
    }


}
