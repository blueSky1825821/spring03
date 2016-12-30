package com.cache.spring;


import org.springframework.cache.annotation.Cacheable;

/**
 * Created by sky on 2016/12/29.
 */
public class AccountService {
    //当调用这个方法的时候，会从一个名叫 accountCache 的缓存中查询，
    // 如果没有，则执行实际的方法（即查询数据库），
    // 并将执行的结果存入缓存中，否则返回缓存中的对象。
    //这里的缓存中的 key 就是参数 userName，value 就是 Account 对象。
    // “accountCache”缓存是在 spring*.xml 中定义的名称。
    @Cacheable(value = "accountCache")
    public Account getAccountByName(String userName) {
        System.out.println("real query account." + userName);
        return getFromDB(userName);
    }

    private Account getFromDB(String acctName) {
        System.out.println("real querying db..." + acctName);
        return new Account(acctName);
    }
}
