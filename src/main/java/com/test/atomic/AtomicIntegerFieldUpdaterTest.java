package com.test.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by wm on 18-3-18.
 */
public class AtomicIntegerFieldUpdaterTest {
    //创建原子更新器，并设置更新需要的对象类和对象的属性
    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");//newUpdater()

    public static void main(String[] args) {
        //设置柯南的年龄
        User conan = new User("conan", 10);
        //柯南长了一岁，但是仍然输出旧的年龄
        System.out.println(a.getAndIncrement(conan));
        //输出柯南现在的年龄
        System.out.println(a.get(conan));
    }

    static class User {
        private String name;
        public volatile int old;// public volatile修饰符
        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }
        public String getName() {
            return name;
        }
        public int getOld() {
            return old;}
    }
}
