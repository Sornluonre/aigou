package com.bailiban.aigou.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bailiban.aigou.dao.UserDao;

import com.bailiban.aigou.entity.User;
import com.bailiban.aigou.service.IUserService;
import com.bailiban.aigou.utils.PageModel;
@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private UserDao userdao;
	@Transactional
	public User login(String username) {
		User login = userdao.login(username);
		return login;
	}
	@Transactional
	public PageModel<User> getUser(PageModel<User> pageModel, User user) {
		// TODO Auto-generated method stub
		return userdao.getUser(pageModel, user);
	}
	@Transactional
	public void save(User user) {
		// TODO Auto-generated method stub
		userdao.save(user);
	}
	@Transactional
	public void update(User user) {
		// TODO Auto-generated method stub
		userdao.update(user);
	}
	@Transactional
	public User getid(String id) {
		// TODO Auto-generated method stub
		return userdao.getid(id);
	}
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		userdao.delete(id);
	}

}
