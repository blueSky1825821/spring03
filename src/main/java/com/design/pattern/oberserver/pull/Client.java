package com.design.pattern.oberserver.pull;

/**
 * Created by wm on 18-1-5.
 */
public class Client {
    public static void main(String[] args) {
        //创建一个报纸，作为被观察者
        NewsPaper subject = new NewsPaper();
        //创建阅读者，也就是观察者
        Reader reader1 = new Reader();
        reader1.setName("zhangsan");

        Reader reader2 = new Reader();
        reader2.setName("lisi");

        Reader reader3 = new Reader();
        reader3.setName("wangwu");

        //注册订阅者
        subject.attach(reader1);
        subject.attach(reader2);
        subject.attach(reader3);

        //要出报纸啦
        subject.setContent("本期内容是观察者模式");
    }
}
