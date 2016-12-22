package com.baidu.www;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by sky on 16-7-5.
 */
public class ProxyMain {
    public static void main(String[] args)
    {
        //代理的目标对象
        ProxyInterFace proxyInterface = new TargetObject();
        //代理器
        ProxyObject proxyObject = new ProxyObject();
        proxyObject.setTargetObject(proxyInterface);
        //转换成InvocationHandler
        InvocationHandler handler = proxyObject;
        //执行代码任务
        Object proxy =  Proxy.newProxyInstance(proxyInterface.getClass().getClassLoader(), proxyInterface.getClass().getInterfaces(),handler );
        //转换成目标对象，调用目标对象的方法
        ((ProxyInterFace)proxy).proxyMethod();

    }
}
