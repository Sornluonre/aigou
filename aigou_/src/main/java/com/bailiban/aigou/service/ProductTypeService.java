package com.bailiban.aigou.service;

import com.bailiban.aigou.entity.ProductType;
import com.bailiban.aigou.entity.User;
import com.bailiban.aigou.utils.PageModel;

public interface ProductTypeService {
	//通过分类名查询分类
	ProductType login(String ProductTypeName);

	/*
	 * 获取商品分类分页数据
	 * */
	PageModel<ProductType> getProducts(PageModel<ProductType> PageModel);
	
	
	//添加分类
	void save(ProductType prod);
	//通过ID查询分类
	ProductType getid(String id);
	//修改分类
	void update(ProductType prod);
	//删除分类
	void delete(String id);
}
