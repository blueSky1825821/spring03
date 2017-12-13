package com.java8new.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wm on 17-8-22.
 */
public class Maps1 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, val) -> System.out.println(val));

        map.computeIfPresent(3, (num, val) -> val + num);

        map.computeIfPresent(9, (num, val) -> null);

        map.computeIfAbsent(23, num -> "val" + num);
        System.out.println(map.containsKey(23));

        map.computeIfAbsent(3, num -> "bam");
        System.out.println(map.get(3));

        System.out.println(map.getOrDefault(42, "not found"));

        map.remove(3, "val3");
        System.out.println(map.get(3));

        // 仔细看merge代码  oldValue value
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));

        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));
    }
}
