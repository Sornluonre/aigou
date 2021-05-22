package com.bailiban.aigou.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bailiban.aigou.dao.ProductTypeDao;
import com.bailiban.aigou.entity.ProductType;
import com.bailiban.aigou.entity.User;
import com.bailiban.aigou.utils.PageModel;



@Repository
public class ProductTypeDaoImpl implements ProductTypeDao{

	  @Resource
	    private SessionFactory sessionFactory;
	  
	
	public PageModel<ProductType> getProducts(PageModel<ProductType> PageModel) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(ProductType.class);
		criteria.setFirstResult((PageModel.getPageNo()-1)*PageModel.getPageSize());
		criteria.setMaxResults(PageModel.getPageSize());
		
		List<ProductType> list = criteria.list();
		PageModel.setList(list);
		
		return PageModel;
	}
	public int getProductTypeCount(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(id) from ProductType");
		List<Long> list=query.list();
		return list.get(0).intValue();
	}
	public void save(ProductType prod) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(prod);
	}
	public ProductType getid(String id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		ProductType prod=session.get(ProductType.class, id);
		return prod;
	
	}
	public void update(ProductType prod) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(prod);
	}
	public void delete(String id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(session.get(ProductType.class, id));
	}
	public ProductType login(String ProductTypeName) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query= session.createQuery("from ProductType where ProductTypeName=:name");
		query.setParameter("name", ProductTypeName);
		List<ProductType> list = query.list();
		if(list==null||list.size()<=0){
			return null;
		}
		return list.get(0);

	}
	
	
}
