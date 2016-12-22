/**
 * @Title: TestHelloWorld.java
 * @Package com.gc.test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author rocky
 * @date 2016年6月27日 下午11:04:37
 */
package com.gc.test;

import java.sql.Time;
import java.util.Date;

import com.gc.action.*;
import com.gc.action.TimeBookProxy;
import com.gc.impl.TimeBookInterface;
import org.junit.Test;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author rocky
 * @ClassName: TestHelloWorld
 * @Description: TODO(作用:)
 * @date 2016年6月27日 下午11:04:37
 */

public class TestHelloWorld {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        //通过ApplicationContext获取XML
        ApplicationContext actx1 = new FileSystemXmlApplicationContext("config.xml");
//		TimeBookInterface timeBookProxy1 = (TimeBookInterface) actx1.getBean("logProxy");
//		timeBookProxy1.doAuditing("刘六");
        boolean i = actx1.containsBean("logProxy");

        TimeBookInterface timeBookProxy2 = (TimeBookInterface) actx1.getBean("logProxy");
        timeBookProxy2.doAuditing("李七");

//		TimeBook timeBook = new TimeBook();
//		timeBook.doAuditing("张三");

        //这里针对接口进行编程
//		TimeBookProxy timeBookProxy = new TimeBookProxy(new TimeBook());
//		timeBookProxy.doAuditing("李四");

        //实现了对日志类的重用
//		LogProxy logProxy = new LogProxy();
//		TimeBookInterface timeBookProxy = (TimeBookInterface) logProxy.bind(new TimeBook());
//		timeBookProxy.doAuditing("王五");


        // 通过ApplicationContext来获取Spring的配置文件
        ApplicationContext actx = new FileSystemXmlApplicationContext("config.xml");
        // 通过Bean的id来获取Bean
        EnHello enHello = (EnHello) actx.getBean("EnHello2");
        System.out.println(enHello.getMsg());

        HelloWorld helloWorld1 = (HelloWorld) actx.getBean("HelloWorld");
        System.out.println(helloWorld1.getMsg());

        HelloWorld helloWorld3 = (HelloWorld) actx.getBean("HelloWorld3");
        System.out.println(helloWorld3.getDate() + " " + helloWorld3.getMsg());

        HelloWorldInit helloWorldInit = (HelloWorldInit) actx.getBean("HelloWorldInit");
        System.out.println("helloWorldInit " + helloWorldInit.getDate() + "" + helloWorldInit.getMsg());

        HelloWorldInit2 helloWorldInit2 = (HelloWorldInit2) actx.getBean("HelloWorldInit2");
        System.out.println("helloWorldInit2 " + helloWorldInit2.getDate() + "" + helloWorldInit2.getMsg());

        HelloWorldDestroy helloWorldDestroy = (HelloWorldDestroy) actx.getBean("HelloWorldDestroy");
        System.out.println("helloWorldDestroy " + helloWorldDestroy.getDate() + "" + helloWorldDestroy.getMsg());

        HelloWorldDestroy2 helloWorldDestroy2 = (HelloWorldDestroy2) actx.getBean("HelloWorldDestroy2");
        System.out.println("helloWorldDestroy2 " + helloWorldDestroy2.getDate() + "" + helloWorldDestroy2.getMsg());

/*		HelloWorldList helloWorldList = (HelloWorldList) actx.getBean("HelloWorldList");
        System.out.println(helloWorldList.getMsg());*/

		
/*		HelloWorldMap helloWorldMap = (HelloWorldMap) actx.getBean("HelloWorldMap");
		System.out.println(helloWorldMap);*/

        //通过Class.forName()方法获取类HelloWorldWrapper的一个实例
        Object obj = Class.forName("com.gc.action.HelloWorldWrapper").newInstance();
        //通过BeanWrapper来设定类HelloWorldWrapper的属性
        BeanWrapperImpl bw = new BeanWrapperImpl(obj);
        //根据类变量设定变量的值
        bw.setPropertyValue("msg", "HelloWorldWrapper");
        bw.setPropertyValue("date", new Date());
        //把刚才设定的值根据变量名进行输出
        System.out.println(bw.getPropertyValue("date") + " " + bw.getPropertyValue("msg"));


        //关闭ApplicationContext
        ((AbstractApplicationContext) actx).registerShutdownHook();


    }

    @Test
    public void test01() {
        TimeBook timeBook = new TimeBook();
        timeBook.doAuditing("张三");
    }

    @Test
    public void test02() {
        TimeBookProxy timeBookProxy = new TimeBookProxy(new TimeBook());
        timeBookProxy.doAuditing("张三");
    }

    @Test
    public void test03() {
        LogProxy logProxy = new LogProxy();
        TimeBookInterface timeBookInterface = (TimeBookInterface) logProxy.bind(new TimeBook());
        timeBookInterface.doAuditing("张三");
    }

    @Test
    public void test04() {
        //通过ApplicationContext获取XML
        ApplicationContext actx = new FileSystemXmlApplicationContext("config.xml");
        TimeBookInterface timeBookInterface = (TimeBookInterface) actx.getBean("logProxy2");
        timeBookInterface.doAuditing("张三");

    }

}
