package com.ThreadTest.test04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 2017/3/9.
 */
public class MyList {
    private List list = new ArrayList();
    public void add() {
        list.add("wang");
    }
    public int size() {
        return list.size();
    }
}
