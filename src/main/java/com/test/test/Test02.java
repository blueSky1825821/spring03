package com.test.test;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by wm on 18-1-6.
 */
public class Test02 {
    @Test
    public void test01() {
        String s1 = "ab" + "c";
        String s2 = "a" + "bc";
        System.out.println(s1 == s2);
    }

    @Test
    public void test02() throws NoSuchFieldException, IllegalAccessException {
        Class<?>[] cache = Integer.class.getDeclaredClasses();
        Field myCache = cache[0].getDeclaredField("cache");
        myCache.setAccessible(true);
        Integer[] newCache = (Integer[]) myCache.get("cache");
        newCache[132] = newCache[133];
        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b);
    }
}
