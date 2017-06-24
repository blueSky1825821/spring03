package com.ibm.thread;

import com.ibm.thread.Client;
import com.ibm.thread.Service;
import com.ibm.thread.ServiceProxy;

/**
 * Created by sky on 2017/6/14.
 */
public class ThreadTest {
    public static void main(String[] args) {
        Service s = new ServiceProxy();
        Client c = new Client(s);
        c.requestService();
    }
}