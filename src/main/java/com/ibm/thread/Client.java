package com.ibm.thread;

/**
 * Created by sky on 2017/6/14.
 */
public class Client {
    private Service _service;
    public Client(Service s) {
        _service = s;
    }
    public void requestService() {
        _service.sayHello();
    }
}
