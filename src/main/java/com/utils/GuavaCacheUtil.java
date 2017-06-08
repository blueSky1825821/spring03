package com.utils;

import com.google.common.cache.*;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * Created by sky on 2017/6/5.
 */
public final class GuavaCacheUtil<K, V> {
    private static Logger logger = Logger.getLogger(GuavaCacheUtil.class);

    /**
     * 查询HIS患者信息key前缀
     */
    private static String preQueryHisCard = "HisCard-";

    private CacheLoader<K, V> cacheLoader;

    private static CacheBuilder<Object, Object> cacheBuilder =
            CacheBuilder.newBuilder().expireAfterWrite(23, TimeUnit.HOURS).maximumSize(1000).initialCapacity(10);

    private static Cache<Object, Object> cache;

    static {
        cache = cacheBuilder.build();
    }

    private GuavaCacheUtil() {

    }

    /**
     * 添加缓存
     *
     * @param key
     * @param value
     */
    public static void set(Object key, Object value) {
        cache.put(key, value);
    }

    /**
     * 删除缓存
     *
     * @param key
     */
    public static void delect(Object key) {
        cache.invalidate(key);
    }

    /**
     * 根据key取得缓存对象
     *
     * @param key
     * @return
     */
    public static Object get(Object key) {
        return cache.getIfPresent(key);
    }

    /**
     * 清除所有缓存
     */
    public static void cleanUp() {
        cache.cleanUp();
    }

}
