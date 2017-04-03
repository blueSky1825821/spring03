package com.baidu.www.proxy.test01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by sky on 16-7-5.
 * 代理类可以在运行时创建全新的类，这样的代理类能实现指定的接口
 */
public class ProxyMain {
    public static void main(String[] args) {
        //代理的目标对象
        ProxyInterFace proxyInterface = new TargetObject();
        //代理器
        ProxyObject proxyObject = new ProxyObject();
        proxyObject.setTargetObject(proxyInterface);
        Class[] interfaces = new Class[]{ProxyInterFace.class};
        //转换成InvocationHandler
        InvocationHandler handler = proxyObject;
        //执行代码任务
        //newProxyInstance 三个主要方法：
        //1、一个类加载器:作为java安全模型的一部分，对于系统类和从因特尔下载下来的类，可以使用不同的类加载器，用null表示默认的类加载器(为null有问题)
        //2、一个Class对象数组：每个元素都是需要实现的接口
        //3、一个调用处理器
        Object proxy = Proxy.newProxyInstance(ProxyMain.class.getClassLoader(), interfaces, handler);
        //转换成目标对象，调用目标对象的方法
        ((ProxyInterFace) proxy).proxyMethod();

    }
}
