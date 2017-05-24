package com.combat1200.beanUtils;

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sky on 2017/5/23.
 * 动态生成javaBean
 */
public class DynaBeanTest {
    public static void main(String[] args) {
        DynaProperty[] properties = new DynaProperty[3];
        //指定属性名称和类型 name:初始化属性的名称 type：属性的类型 contentType：indexed或Mapped类型的属性元素类型
        properties[0] = new DynaProperty("name", String.class);
        properties[1] = new DynaProperty("phoneNumber", String[].class, String.class);
        properties[2] = new DynaProperty("address", Map.class, String.class);
        //BasicDynaClass 最小化的实现了DynaBean接口
        BasicDynaClass dynaClass = new BasicDynaClass("employee", null, properties);
        DynaBean employee = null;
        try {
            employee = dynaClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        employee.set("name", "wang");
        employee.set("phoneNumber", new String[10]);    //索引类型要先初始化
        employee.set("phoneNumber", 0, "1234567");
        employee.set("address", new HashMap<String, String>()); //映射类型要初始化
        employee.set("address", "home", "anhui");
        String name = (String) employee.get("name");
        String phoneNumber = (String) employee.get("phoneNumber", 0);
        String address = (String) employee.get("address", "home");
        System.out.println(name + "\t" + phoneNumber + "\t" + address + "\t");
    }
}
