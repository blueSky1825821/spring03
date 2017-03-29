package com.threadTest.thread.add.state.simpleDateFormat.test02;

import java.text.SimpleDateFormat;

/**
 * Created by sky on 2017/3/24.
 */
public class Test {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateStringArray = new String[]{"2000-01-01", "2001-02-02", "2003-03-03", "2004-04-04"};
        MyThread[] threadArray = new MyThread[4];
        for (int i = 0; i < dateStringArray.length; i++) {
            threadArray[i] = new MyThread(sdf, dateStringArray[i]);
        }
        for (int i = 0; i < dateStringArray.length; i++) {
            threadArray[i].start();
        }
    }
}
