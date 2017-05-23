package com.combat1200.enumandgenericity.genericity04;

import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/5/22.
 */
public class GenericComparison {
    public static <T extends Comparable<T>> T getMin(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        T min = array[0];   //假设最小的元素
        for (int i = 1; i < array.length; i++) {
            if (min.compareTo(array[i])>0) {
                min =array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String[] a = new String[]{"1", "2", "3"};
        System.out.println(GenericComparison.getMin(a));
    }
}
