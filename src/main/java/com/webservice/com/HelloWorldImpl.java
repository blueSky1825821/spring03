package com.webservice.com;

import javax.jws.WebService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sky on 16-7-19.
 * 编写服务实现
 */
@WebService(endpointInterface = "com.webservice.com.HelloWorld", serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    Map<Integer, User> users = new LinkedHashMap<Integer, User>();

    public String sayHi(String text) {
        return "Hello" + text;
    }

    public String sayHiToUser(User user) {
        try {
            Thread.currentThread().sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        users.put(users.size() + 1, user);
        return "Hello" + user.getName();
    }

    public String[] sayHiToUserList(List<User> userList) {
        try {
            Thread.currentThread().sleep(300000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String[] result = new String[userList.size()];
        int i = 0;
        for (User u : userList) {
            result[i] = "Hello" + u.getName();
            i++;
        }
        return result;
    }
}
