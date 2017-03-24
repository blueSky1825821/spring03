package com.threadTest.thread.add.state.group.test02;

/**
 * Created by sky on 2017/3/23.
 */
public class Run {
    public static void main(String[] args) {
        //在main组中添加一个线程组A，然后在这个A中添加线程对象Z
        //方法acctiveGroupCount()个acctiveCount()的值不是固定的
        //是系统环境的一个快照
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup group = new ThreadGroup(mainGroup, "A");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runMethod!");
                try {
                    Thread.sleep(10000); //线程必须在运行状态下才可以受组管理
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread newThread = new Thread(group, runnable);
        newThread.setName("Z");
        newThread.start();//线程必须启动后才归到A组中
        ThreadGroup[] listGroup = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(listGroup);
        System.out.println("main 线程中有多少个子线程组： " + listGroup.length + " 名字为： " + listGroup[0].getName());;
        Thread[] listThread = new Thread[listGroup[0].activeCount()];
        //将此listGroup[0]线程组中的每个活动线程复制到指定的数组中listThread
        listGroup[0].enumerate(listThread);
        System.out.println(listThread[0].getName());
    }
}
