package com.yiibai.mybatis.mapper;

import java.util.List;
import com.yiibai.mybatis.pojo.Order;
import com.yiibai.mybatis.pojo.User;

public interface UserMaper { 
	User getUserById(int userId);
	List<Order> getUserOrders(int userId);
	int insertUser(User user);
	//入参是多个id 返回对象
	List<User> getUsers(List<Integer> idList);
}
