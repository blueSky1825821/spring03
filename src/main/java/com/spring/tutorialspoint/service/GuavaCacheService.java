package com.spring.tutorialspoint.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by wm on 2017/6/5.
 */
@Service("guavaCacheService")
public class GuavaCacheService {
    private static Logger logger = Logger.getLogger(GuavaCacheService.class);

    /**
     * 查询HIS患者信息key前缀
     */
    public String preQueryHisCard = "HisCard-";

    public CacheBuilder<Object, Object> cacheBuilder =
            CacheBuilder.newBuilder().expireAfterWrite(23, TimeUnit.HOURS).maximumSize(5).initialCapacity(2);

    public Cache<Object, Object> cache = cacheBuilder.build();

    public GuavaCacheService() {

    }

    /**
     * 添加缓存
     *
     * @param key
     * @param value
     */
    public void put(Object key, Object value) {
        cache.put(key, value);
    }

    /**
     * 删除缓存
     *
     * @param key
     */
    public void delect(Object key) {
        cache.invalidate(key);
    }

    /**
     * 根据key取得缓存对象
     *
     * @param key
     * @return
     */
    public Object get(Object key) {
        return cache.getIfPresent(key);
    }

    /**
     * 清除所有缓存
     */
    public void cleanUp() {
        cache.cleanUp();
    }

}
