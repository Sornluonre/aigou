package com.bailiban.aigou.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bailiban.aigou.dao.ProductTypeDao;
import com.bailiban.aigou.entity.ProductType;
import com.bailiban.aigou.service.ProductTypeService;
import com.bailiban.aigou.utils.PageModel;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Resource
	private ProductTypeDao productTypeDao;
	
	@Transactional
	public PageModel<ProductType> getProducts(PageModel<ProductType> PageModel) {
		// TODO Auto-generated method stub
		PageModel<ProductType> PageModel2 = productTypeDao.getProducts(PageModel);
		int count = productTypeDao.getProductTypeCount();
		PageModel2.setTotalRecords(count);
		return PageModel2;	
	}
	@Transactional
	public void save(ProductType prod) {
		// TODO Auto-generated method stub
		productTypeDao.save(prod);
	}
	@Transactional
	public ProductType getid(String id) {
		// TODO Auto-generated method stub
		ProductType type = productTypeDao.getid(id);
		return type;
	}
	@Transactional
	public void update(ProductType prod) {
		// TODO Auto-generated method stub
		productTypeDao.update(prod);
	}
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		productTypeDao.delete(id);
	}
	public ProductType login(String ProductTypeName) {
		// TODO Auto-generated method stub
		ProductType type = productTypeDao.login(ProductTypeName);
		return type;
	}


}
