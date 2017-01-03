package com.cache.spring;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
    @Cacheable(value="accountCache",condition="#userName.length() <= 4")// 缓存名叫 accountCache
    public Account getAccountByName(String userName, String password) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        return getFromDB(userName, password);
    }

     //# 号代表这是一个 SpEL 表达式，此表达式可以遍历方法的参数对象，
    @CacheEvict(value = "accountCache", key = "#account.getName()")// 清空 accountCache 缓存 Key 是用来指定缓存的 key 的
    public void updateAccount(Account account) {
        updateDB(account);
    }


    @CachePut(value="accountCache",key="#account.getName()")// 更新 accountCache 缓存
    public Account updateAccount01(Account account) {
        return updateDB01(account);
    }

    // 清空 accountCache 缓存 表示是否需要清除缓存中的所有元素。默认为false，表示不需要。当指定了allEntries为true时，Spring Cache将忽略指定的key。
    @CacheEvict(value = "accountCache", allEntries = true)
    public void reload() {
    }

    private Account getFromDB(String acctName, String password) {
        System.out.println("real querying db..." + acctName);
        return new Account(acctName);
    }

    private void updateDB(Account account) {
        System.out.println("real update db..." + account.getName());
    }

    //组合key 同样的才能从缓存获取
    @Cacheable(value="accountCache",key="#userName.concat(#password)")
    public Account getAccount(String userName,String password,boolean sendLog) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        return getFromDB(userName,password);

    }

    private Account updateDB01(Account account) {
        System.out.println("real updating db..."+account.getName());
        return account;
    }
}
