package com.baidu.proxy.test03;

import com.gc.action.HelloWorld;
import com.spring.advice.LogInterceptor;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by wm on 17-12-19.
 */
public class GcLibTest {
    public static void main(String[] args) {
        //创建一个增强器，用来在运行时生成类
        Enhancer enhancer = new Enhancer();
        //设置要继承的目标类
        enhancer.setSuperclass(HelloDate.class);
        //设置LogInterceptor
        enhancer.setCallback((Callback) new LogInterceptor());
        //生成新的代理类
        HelloDate hw = (HelloDate) enhancer.create();
        //调用代理方法
        hw.test();
    }

    public class HelloDate{
        public void test(){
            System.out.println("------");
        }
    }
}
