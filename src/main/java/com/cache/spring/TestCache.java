package com.cache.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sky on 2016/12/29.doctqueueInfo
 */
public class TestCache {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-cache-anno.xml");// 加载 spring 配置文件

        AccountService s = (AccountService) context.getBean("accountService");
        // 第一次查询，应该走数据库
        System.out.print("first query...");
        s.getAccountByName("somebody", "");
        // 第二次查询，应该不查数据库，直接返回缓存的值
        System.out.print("second query...");
        s.getAccountByName("somebody", "");
        System.out.println();

        System.out.println("start testing clear cache...");    // 更新某个记录的缓存，首先构造两个账号记录，然后记录到缓存中
        Account account1 = s.getAccountByName("somebody1", "");
        Account account2 = s.getAccountByName("somebody2", "");
        // 开始更新其中一个    account1.setId(1212);
        s.updateAccount(account1);
        s.getAccountByName("somebody1", "");// 因为被更新了，所以会查询数据库    s.getAccountByName("somebody2");// 没有更新过，应该走缓存    s.getAccountByName("somebody1");// 再次查询，应该走缓存    // 更新所有缓存
        s.reload();
        s.getAccountByName("somebody1", "");// 应该会查询数据库    s.getAccountByName("somebody2");// 应该会查询数据库    s.getAccountByName("somebody1");// 应该走缓存    s.getAccountByName("somebody2");// 应该走缓存
    }

    @Test
    public void testkey() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-cache-anno.xml");// 加载 spring 配置文件

        AccountService s = (AccountService) context.getBean("accountService");
        s.getAccount("somebody", "123456", true);// 应该查询数据库
        s.getAccount("somebody", "123456", true);// 应该走缓存
        s.getAccount("somebody", "123456", false);// 应该走缓存
        s.getAccount("somebody", "654321", true);// 应该查询数据库
        s.getAccount("somebody", "654321", true);// 应该走缓存
    }

    @Test
    public void test02() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-cache-anno.xml");// 加载 spring 配置文件

        AccountService s = (AccountService) context.getBean("accountService");

        Account account = s.getAccountByName("someone", "1");
        account.setPassword("123");
        s.updateAccount01(account);
        account.setPassword("321");
        s.updateAccount(account);
        account = s.getAccountByName("someone", "1");
        System.out.println(account.getPassword());
    }
}
