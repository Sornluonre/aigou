package com.bailiban.aigou.dao;

import com.bailiban.aigou.entity.User;
import com.bailiban.aigou.utils.PageModel;

public interface UserDao {
	//通过用户名查询用户
	User login(String username);
	//获取用户分页数据
	PageModel<User> getUser(PageModel<User> pageModel, User user);
	//添加用户
	void save(User user);
	//通过ID查询用户
	User getid(String id);
	//修改用户
	void update(User user);
	//删除用户
	void delete(String id);
}
