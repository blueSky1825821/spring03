package com.threadTest.thread.test05;

import com.threadTest.thread.test04.MyList;
import com.threadTest.thread.test04.ThreadA;
import com.threadTest.thread.test04.ThreadB;

/**
 * Created by sky on 2017/3/9.
 */
public class Test {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);
        ThreadP threadP = new ThreadP(p);
        ThreadC threadC = new ThreadC(c);
        threadP.start();
        threadC.start();
    }
}
