package com.combat1200.thread.t02;

public class Bank {

	// 使用ThreadLocal类来管理共享变量account
	// 线程本地变量，也有些地方叫做线程本地存储，其实意思差不多。
	// 可能很多朋友都知道ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内部的副本变量。
	private static ThreadLocal<Integer> account = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 100;// 重写initialValue()方法，将account的初始值设为100
		}
	};

	public void deposit(int money) {
		account.set(account.get() + money);// 利用account的get()、set()方法实现存钱
	}

	public int getAccount() {// 获得账户余额
		return account.get();
	}
}
