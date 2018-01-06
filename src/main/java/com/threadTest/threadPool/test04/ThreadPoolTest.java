package com.threadTest.threadPool.test04;

import com.utils.ThreadPoolExecutorUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sky on 2017/6/21.
 */
public class ThreadPoolTest {
    @Test
    public void test01() {
        String name = "test";
        ThreadPoolExecutor executor01 = ThreadPoolExecutorUtil.getAllThreadPool("pull");
        executor01.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("pull " + Thread.currentThread().getName());
            }
        });
        ThreadPoolExecutor executor05 = ThreadPoolExecutorUtil.getAllThreadPool("pull");
        executor05.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
                System.out.println("test05");
            }
        });
        ThreadPoolExecutor executor02 = ThreadPoolExecutorUtil.getAllThreadPool("pull");
        executor02.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("test02");
            }
        });
        ThreadPoolExecutor executor03 = ThreadPoolExecutorUtil.getAllThreadPool("pull");
        executor03.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("test03");
            }
        });
        ThreadPoolExecutor executor09 = ThreadPoolExecutorUtil.getAllThreadPool("pull");
        executor09.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("test03");
            }
        });
        ThreadPoolExecutor executor06 = ThreadPoolExecutorUtil.getAllThreadPool("pull");
        executor06.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("test03");
            }
        });
        ThreadPoolExecutor executor07 = ThreadPoolExecutorUtil.getAllThreadPool("pull");
        executor07.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("test03");
            }
        });
        ThreadPoolExecutor executor08 = ThreadPoolExecutorUtil.getAllThreadPool("test04");
        executor08.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("test04");
            }
        });
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() {
        AtomicInteger num = new AtomicInteger(10);
        System.out.println(num.incrementAndGet());
    }

    @Test
    public void test03() {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ScheduledExecutorService timer = (ScheduledExecutorService) ThreadPoolExecutorUtil.getScheThreadPool("test");
        System.out.printf("起始时间：%s\n\n", new SimpleDateFormat("HH:mm:ss").format(new Date()));
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.printf("定时时间：%s\n\n", new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }, 10, 30, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04() {

    }
}
