package com.ibm.thread;

/**
 * Created by sky on 2017/6/14.
 */
public class ServiceProxy implements Service{
    private Service _service;
    private ActiveObject _active_object;

    public ServiceProxy() {
        _service = new ServiceImp();
        _active_object = new ActiveObject();
    }

    @Override
    public void sayHello() {
        MethodRequest mr = new SayHello(_service);
        _active_object.enqueue(mr);
    }
}
