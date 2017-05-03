package com.webservice.com;


import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 16-7-19.
 */
public class HelloWorldClient {
    public static void main(String[] args) {
        String url = "http://localhost:10000/helloWorld?wsdl";
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(url);
//sayHello 为接口中定义的方法名称  张三为传递的参数   返回一个Object数组
        Object[] objects = new Object[3];
        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setName("wang");
        userList.add(user);
        try {
            objects[0] = client.invoke("sayHi", "张三");
            System.out.println(objects[0]);
        } catch (SocketTimeoutException se1) {
            System.out.println("超时");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            objects[1] = client.invoke("sayHiToUser", user);
            System.out.println(objects[1]);
        } catch (SocketTimeoutException se1) {
            System.out.println("超时");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            objects[2] = client.invoke("sayHiToUserList", userList);
            System.out.println(objects[2]);
        } catch (SocketTimeoutException se1) {
            System.out.println("超时");
        } catch (Exception e) {
            e.printStackTrace();
        }
//输出调用结果
    }

    @Test
    public String test() {
        String s = "";
        String url = "http://10.130.107.11:8081/KWSService.asmx?wsdl";
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(url);
//sayHello 为接口中定义的方法名称  张三为传递的参数   返回一个Object数组
        Object[] objects = new Object[]{"QueryPatient", "<Request><cardNo>1212163571</cardNo><cardType>2</cardType></Request>", ""};
        try {
            Object[] objects1 = client.invoke("WebBusiness", objects);
            s = objects1[1].toString().trim();
        } catch (SocketTimeoutException se1) {
            System.out.println("超时");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
