package com.threadTest.threadPool.test02;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by sky on 2017/6/16.
 * 处理不能处理的队列
 */
public class RejectExecutionHandlerImpl implements RejectedExecutionHandler{
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + " is rejected");
    }
}
