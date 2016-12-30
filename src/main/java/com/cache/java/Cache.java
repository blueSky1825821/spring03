package com.cache.java;

import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by sky on 2016/12/28.
 */
public class Cache {
    private Cache dataCache =
            (Cache) CacheBuilder.newBuilder().expireAfterWrite(23, TimeUnit.HOURS).build();

    public static void main(String[] args) {

    }

}
