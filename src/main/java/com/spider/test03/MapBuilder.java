package com.spider.test03;

/**
 * 方便构建map 主要为了方便构建查询queryData
 * Created by colar on 16-1-12.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MapBuilder<K, V> {




    Map<K, V> internalMap;

    private MapBuilder(K key, V value) {
        // 隐藏构造函数
        internalMap = new HashMap<>();
        internalMap.put(key,value);
    }

    private MapBuilder(Map<K, V> mapHolder) {
        internalMap = mapHolder;
    }

    public static <K, V> MapBuilder init(K key, V value) {
        return new MapBuilder<K, V>(key, value);
    }

    public static <K, V> MapBuilder init(Map<K, V> mapHolder) {
        return new MapBuilder<K, V>(mapHolder);
    }

    public MapBuilder put(K key, V value) {
        internalMap.put(key, value);
        return this;
    }

    public Map<K, V> build() {
        return internalMap;
    }

    public static <T> Map<String,Object> listToMap(List<T> list ,Integer total,Integer offset,Integer size){
        return MapBuilder.init("data", list).put("total", total == null ? (list == null ? 0 : list.size()) : total).build();
    }

}
