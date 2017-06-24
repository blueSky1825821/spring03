package com.threadTest.threadPool.test03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by sky on 2017/6/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:threadPool.xml")
public class TestThreadPool {
    private static int produceTaskSleepTime = 10;
    private static int produceTaskMaxNumber = 100;
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
        return threadPoolTaskExecutor;
    }

    public void setThreadPoolTaskExecutor(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

    @Test
    public void testThreadPoolExecutor() {
        for (int i = 1; i < produceTaskMaxNumber; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(produceTaskSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new StartTaskThread(threadPoolTaskExecutor, i)).start();
        }
//        threadPoolTaskExecutor.shutdown();
    }
}
