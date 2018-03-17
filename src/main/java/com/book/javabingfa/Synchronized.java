package com.book.javabingfa;

/**
 * Created by wm on 18-2-27.
 */
public class Synchronized {
    public static void main(String[] args) {
        synchronized (Synchronized.class) {
        }
        m();
    }
    public static synchronized void m() {

    }
}
