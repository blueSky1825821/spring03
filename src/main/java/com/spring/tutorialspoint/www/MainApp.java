package com.spring.tutorialspoint.www;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sky on 2016/12/12.
 */
public class MainApp {

    //配置初始化和销毁方法
    @Test
    public void test01() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
        context.registerShutdownHook();
    }

    //bean before and after initialization
    @Test
    public void test02() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
        context.registerShutdownHook();
    }

    //Bean Definition Inheritance 继承
    @Test
    public void test03() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
        objA.getMessage1();
        objA.getMessage2();

        HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
        objB.getMessage1();
        objB.getMessage2();
        objB.getMessage3();
    }

    @Test
    public void test04() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        TextEditor te = (TextEditor) context.getBean("textEditor");
        te.spellCheck();
    }

    @Test
    public void test05() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");

        JavaCollection jc = (JavaCollection) context.getBean("javaCollection");

        jc.getAddressList();
        jc.getAddressSet();
        jc.getAddressMap();
        jc.getAddressProp();
    }

    @Test
    public void test06() {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(HelloWorldConfig.class);

        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);

        helloWorld.setMessage("Hello World!");
        helloWorld.getMessage();
    }

    //Listening to Context Events
    @Test
    public void test07() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        //let us raise a start event
        context.start();
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
        //let us raise a start event
        context.stop();
    }

    @Test
    public void test08() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        CustomEventPublisher customEventPublisher = (CustomEventPublisher) context.getBean("customEventPublisher");
        customEventPublisher.publish();
        customEventPublisher.publish();
    }
}
