package com.yiibai.mapper;

import java.util.List;
import com.yiibai.pojo.Order;
import com.yiibai.pojo.User;

public interface UserMaper { 
	User getUserById(int userId);
	List<Order> getUserOrders(int userId);
	int insertUser(User user);
}
