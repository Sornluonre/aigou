package com.bailiban.aigou.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bailiban.aigou.constants.BaseAction;
import com.bailiban.aigou.entity.ProductType;
import com.bailiban.aigou.service.ProductTypeService;
import com.bailiban.aigou.utils.PageModel;

@Controller
@Scope("prototype")
@Namespace("/admin/product")
public class ProductAction extends BaseAction{


	
	@Action(value="list",results={
			@Result(name = SUCCESS,location = SYS_JSP_BASEURL+"admin/product/list.jsp")
	 })
	public String list(){
		 HttpServletRequest request = ServletActionContext.getRequest();
		 PageModel<Object> model = new PageModel<Object>();
		 model.setPageNo(1);
		 model.setPageSize(10);
		 model.setTotalRecords(100);
		 request.setAttribute("productPages", model);
		 return SUCCESS;
		
	}
	
	@Action(value="addPage",results={
			@Result(name = SUCCESS,location = SYS_JSP_BASEURL+"admin/product/add.jsp")
	 })
	public String addPage(){
		 HttpServletRequest request = ServletActionContext.getRequest();
		
		 return SUCCESS;
		
	}
}
