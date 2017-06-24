package com.ibm.thread;

/**
 * Created by sky on 2017/6/14.
 */
public class SayHello implements MethodRequest {
    private Service _service;

    public SayHello(Service s) {
        _service = s;
    }

    @Override
    public void call() {
        _service.sayHello();
    }
}
