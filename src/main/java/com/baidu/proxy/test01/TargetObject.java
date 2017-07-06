package com.baidu.proxy.test01;

/**
 * Created by sky on 16-7-5.
 */
public class TargetObject implements ProxyInterFace {

    public void proxyMethod() {
        System.out.println("我被代理了，哈哈！");
    }
}
