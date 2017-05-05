package com.combat1200.thread.t03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadPoolTest {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();//创建Runtime对象
        run.gc();//
        long freeMemory = run.freeMemory();//
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            new Thread(new TempThread()).start();
        }
        System.out.println("独立运行1000个线程所占用的内存：" + (freeMemory - run.freeMemory()) + "字节");// 查看内存的变化
        System.out.println("独立创建1000个线程所消耗的时间：" + (System.currentTimeMillis() - currentTime) + "毫秒");// 查看时间的变化

        run.gc();
        freeMemory = run.freeMemory();
        currentTime = System.currentTimeMillis();
        ExecutorService executorServeice = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 1000; i++) {
            executorServeice.submit(new TempThread());
        }
        System.out.println("使用连接池运行1000个线程所占用的内存：" + (freeMemory - run.freeMemory()) + "字节");// 查看内存的变化
        System.out.println("使用连接池创建1000个线程所消耗的时间：" + (System.currentTimeMillis() - currentTime) + "毫秒");// 查看时间的变化
        executorServeice.shutdownNow();
        run.gc();
    }
}
