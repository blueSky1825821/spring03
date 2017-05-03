package com.audition;

/**
 * Created by sky on 2017/4/27.
 * 计算时间复杂度
 */
public class Complex {
    public void test() {
        int n = 10;
        long x = 0;
        for (int i = 0; i < n; i++) {   //O(n)
            for (int j = 0; j < n; j += n / 2) {    //O(1)
                for (int k = 1; k < n; k = 2 * k) {    //O(log(n))
                    x = x + 1;
                }
            }
        }
    }
}
