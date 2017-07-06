package com.baidu.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Created by sky on 17-7-5.
 */
public class BeanInfoUtil {
    public static void setProperty(UserInfo userInfo, String userName) throws Exception {
        PropertyDescriptor propDesc = new PropertyDescriptor(userName, UserInfo.class);
        Method methodSetUserName = propDesc.getWriteMethod();
        methodSetUserName.invoke(userInfo, "wang");
        System.out.println("Set userName: " + userInfo.getUserName());
    }

    public static void getProperty(UserInfo userInfo, String userName) throws Exception {
        PropertyDescriptor propDesc = new PropertyDescriptor(userName, UserInfo.class);
        Method methodGetUserName = propDesc.getReadMethod();
        Object objUserName = methodGetUserName.invoke(userInfo);
        System.out.println("Get userName: " + objUserName.toString());
    }

    public static void setPropertyByIntrospector(UserInfo userInfo, String userName) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(UserInfo.class);
        PropertyDescriptor[] proDescrtptors = beanInfo.getPropertyDescriptors();
        if (proDescrtptors != null && proDescrtptors.length > 0) {
            for (PropertyDescriptor propDesc : proDescrtptors) {
                if (propDesc.getName().equals(userName)) {
                    Method methodSetUserName = propDesc.getWriteMethod();
                    methodSetUserName.invoke(userInfo, "alan");
                    System.out.println("set userName: " + userInfo.getUserName());
                    break;
                }
            }
        }
    }

    public  static void getPropertyByIntrospector(UserInfo userInfo, String userName) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(UserInfo.class);
        PropertyDescriptor[] propertyDescriptors= beanInfo.getPropertyDescriptors();
        if (propertyDescriptors != null && propertyDescriptors.length > 0) {
            for (PropertyDescriptor propDesc : propertyDescriptors) {
                if (propDesc.getName().equals(userName)) {
                    Method methodGetUserName = propDesc.getReadMethod();
                    Object objUserName = methodGetUserName.invoke(userInfo);
                    System.out.println("get userName: " + objUserName);
                }
            }
        }
    }
}
