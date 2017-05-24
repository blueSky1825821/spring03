package com.combat1200.beanUtils;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sky on 2017/5/23.
 * 设置javaBean的简单属性
 */
public class Employee {
    private String name;
    private String[] phoneNumber = new String[10];
    private Map<String, String> address = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String[] phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<String, String> getAddress() {
        return address;
    }

    public void setAddress(Map<String, String> address) {
        this.address = address;
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        String name = employee.getName();
        String phoneNumber = employee.getPhoneNumber()[0];
        String address = employee.getAddress().get("home");

        try {
            //使用PropertyUtils类的方法对Employee对象的域赋值
            PropertyUtils.setSimpleProperty(employee, "name", "wang");
            PropertyUtils.setIndexedProperty(employee, "phoneNumber", 0, "1234567");
            PropertyUtils.setMappedProperty(employee, "address", "home", "anhui");

            //获得Employee对象的属性值
            name = (String) PropertyUtils.getSimpleProperty(employee, "name");
            phoneNumber = (String) PropertyUtils.getIndexedProperty(employee, "phoneNumber", 0);
            address = (String) PropertyUtils.getMappedProperty(employee, "address", "home");
            System.out.println(name + "\t" + phoneNumber + "\t" + address + "\t");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
