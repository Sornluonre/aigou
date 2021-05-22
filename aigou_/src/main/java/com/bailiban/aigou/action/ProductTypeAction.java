package com.bailiban.aigou.action;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bailiban.aigou.constants.BaseAction;
import com.bailiban.aigou.entity.ProductType;
import com.bailiban.aigou.entity.User;
import com.bailiban.aigou.service.ProductTypeService;
import com.bailiban.aigou.utils.IconfontUtils;
import com.bailiban.aigou.utils.PageModel;

@Controller
@Scope("prototype")
@Namespace("/admin/productType")
public class ProductTypeAction extends BaseAction{
	
	@Autowired
	private ProductTypeService productTypeService;
	
	@Action(value="list",results={
			@Result(name = SUCCESS,location = SYS_JSP_BASEURL+"admin/product_type/list.jsp")
	 })
	public String list(){
		 HttpServletRequest request = ServletActionContext.getRequest();
		 super.setPageNo(request.getParameter("pageNo"));
		 super.setPageSize(request.getParameter("pageSize"));
		 //查询数据库
		 PageModel<ProductType> pageModel = new PageModel<ProductType>();
		 pageModel.setPageNo(getPageNo());
		 pageModel.setPageSize(getPageSize());
		 PageModel<ProductType> products = productTypeService.getProducts(pageModel);
		 request.setAttribute("productTypePages", products);
		 return SUCCESS;
		
	}

	
	@Action(value="addPage",results={
			@Result(name = SUCCESS,location = SYS_JSP_BASEURL+"admin/product_type/add.jsp")
	 })
	public String addPage(){
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			List<String> list = IconfontUtils.getIconfonts(request);
			request.setAttribute("iconfonts", list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return SUCCESS;
		
	}
	/**
	 * 分类添加方法
	 * @return
	 */
	@Action(value = "add")
	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String productTypeName = request.getParameter("productTypeName");
		String productTypeIcon = request.getParameter("productTypeIcon");
		ProductType type = new ProductType();
		type.setProductTypeName(productTypeName);
		type.setProductTypeIcon(productTypeIcon);
		productTypeService.save(type);
		request.setAttribute("url", "admin/productType/list");
		return SYS_ACTION_CLOSE;
	}
	
	/**
	 * 用户修改界面
	 * @return
	 */
	@Action(value = "updatePage", results = {
			@Result(name = SUCCESS, location = SYS_JSP_BASEURL+"admin/product_type/update.jsp")
	})
	public String updatePage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<String> list;
		try {
			list = IconfontUtils.getIconfonts(request);
			request.setAttribute("iconfonts", list);
			String id =  request.getParameter("id");
			ProductType type=productTypeService.getid(id);
			request.setAttribute("productType", type);
			return SUCCESS;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return SYS_ACTION_CLOSE;
		}
		
	}
	
	/**
	 * 用户修改方法
	 * @return
	 */
	@Action(value = "update")
	public String update(){
		System.out.println("修改");
		HttpServletRequest request = ServletActionContext.getRequest();
		String productTypeName = request.getParameter("productTypeName");
		String productTypeIcon = request.getParameter("productTypeIcon");
		String id = request.getParameter("id");
		ProductType type = new ProductType();
		type.setProductTypeName(productTypeName);
		type.setProductTypeIcon(productTypeIcon);
		type.setId(id);
		productTypeService.update(type);
		request.setAttribute("url", "admin/productType/list");
		return SYS_ACTION_CLOSE;
	}
	
	@Action(value = "delete", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/jsp/aigou/success.jsp")
	})
	public String delete(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		productTypeService.delete(id);
		request.setAttribute("url", "admin/productType/list");
		return SUCCESS;
		
	}
	 
}
