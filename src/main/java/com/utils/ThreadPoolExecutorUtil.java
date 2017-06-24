package com.utils;

import com.google.common.collect.Maps;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wangmin
 * 可控制线程最大并发数，超出的线程会在队列中等待
 */
public class ThreadPoolExecutorUtil {
    private static Logger logger = Logger.getLogger(ThreadPoolExecutorUtil.class);

    public static Map<String, ThreadPoolExecutor> threadExcutor = Maps.newConcurrentMap();

    public static ThreadPoolExecutor getAllThreadPool(String name) {
        ThreadPoolExecutor executor = threadExcutor.get(name);
        if (null == executor) {
            executor = ThreadPoolExecutorUtil.nameFixMaxThreadPool(name, 3, 2);
            threadExcutor.put(name, executor);
        }

        executor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        return executor;
    }

    public static ThreadPoolExecutor getScheThreadPool(final String name) {
        ThreadPoolExecutor executor = threadExcutor.get(name);
        if (null == executor) {
            executor = ThreadPoolExecutorUtil.scheThreadPool(name);
            threadExcutor.put(name, executor);
        }

        executor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        return executor;
    }

    public static ThreadPoolExecutor scheThreadPool(final String groupName) {
        return new ScheduledThreadPoolExecutor(2, new ThreadFactory() {
            private AtomicInteger num = new AtomicInteger(10);

            @Override
            public Thread newThread(@NotNull Runnable r) {
                Thread thread = new Thread(r);
                thread.setName(groupName + " - " + num.incrementAndGet());
                return thread;
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                logger.info(groupName + "-- rejected execution");
            }
        });
    }


    public static ThreadPoolExecutor nameFixMaxThreadPool(final String groupName, final int max, final int qsize) {
        return nameFixMaxThreadPool(groupName, max, qsize, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                logger.info(groupName + "-- rejected execution");
            }
        });
    }

    public static ThreadPoolExecutor nameFixMaxThreadPool(final String groupName, final int max, final int qsize, RejectedExecutionHandler handler) {
        return new ThreadPoolExecutor(2, max, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(qsize), new ThreadFactory() {
            private AtomicInteger num = new AtomicInteger(10);

            @Override
            public Thread newThread(@NotNull Runnable r) {
                Thread thread = new Thread(r);
                thread.setName(groupName + " - " + num.incrementAndGet());
                return thread;
            }
        }, handler);
    }

    public static ThreadPoolExecutor nameFixMaxThreadPooler(final String groupName, final int max, final int qsize, RejectedExecutionHandler handler) {
        return new ThreadPoolExecutor(2, max, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(qsize), new ThreadFactory() {
            private AtomicInteger num = new AtomicInteger(10);

            @Override
            public Thread newThread(@NotNull Runnable r) {
                Thread thread = new Thread(r);
                thread.setName(groupName + " - " + num.incrementAndGet());
                return thread;
            }
        }, handler);
    }
}
