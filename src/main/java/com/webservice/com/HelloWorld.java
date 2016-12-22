package com.webservice.com;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by sky on 16-7-19.
 * 服务点接口
 */
@WebService
public interface HelloWorld {
    String sayHi(@WebParam(name="text")String text);
    String sayHiToUser(User user);
    String[] sayHiToUserList(List<User> userList);
}
