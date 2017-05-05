package com.combat1200.thread.t03;

public class TempThread implements Runnable {// 测试用的Runnable接口实现类
    private int id = 0;

    @Override
    public void run() {// run()方法给id做自增运算
        id++;
    }
}