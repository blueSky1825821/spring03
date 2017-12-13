package com.test.test;

/**
 * Created by wm on 17-10-8.
 */
public class Inc {
    public static void main(String[] args) {
        Inc inc = new Inc();
        int i = 0;
        inc.fermin(i);
        i = ++i;
        System.out.println(i);

    }

    void fermin(int i) {
        i++;
        System.out.println(i);
    }
}
