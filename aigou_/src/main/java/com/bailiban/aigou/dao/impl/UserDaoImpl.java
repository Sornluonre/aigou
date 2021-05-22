package com.bailiban.aigou.dao.impl;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bailiban.aigou.dao.UserDao;
import com.bailiban.aigou.entity.User;
import com.bailiban.aigou.utils.PageModel;

@Repository
public class UserDaoImpl implements UserDao{
	     @Resource
	    private SessionFactory sessionFactory;

	  

	public User login(String username) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query= session.createQuery("from User where username=:name");
		query.setParameter("name", username);
		List<User> list = query.list();
		if(list==null||list.size()<=0){
			return null;
		}
		return list.get(0);
		
	}



	public PageModel<User> getUser(PageModel<User> pageModel, User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.setFirstResult((pageModel.getPageNo()-1) * pageModel.getPageSize());
		criteria.setMaxResults(pageModel.getPageSize());
		List<User> list = criteria.list();
		pageModel.setList(list);
		return pageModel;
	}



	public void save(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
	}



	public void update(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(user);
	
	}



	public User getid(String id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		User user=session.get(User.class, id);
		return user;
	}



	public void delete(String id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(session.get(User.class, id));
	}

}
