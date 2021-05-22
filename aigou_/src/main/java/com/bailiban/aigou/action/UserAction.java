package com.bailiban.aigou.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bailiban.aigou.constants.BaseAction;
import com.bailiban.aigou.entity.User;
import com.bailiban.aigou.service.IUserService;
import com.bailiban.aigou.service.impl.UserServiceImpl;
import com.bailiban.aigou.utils.PageModel;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")

@Results({
	@Result(name = "error", location =  "/WEB-INF/jsp/aigou/admin/500.jsp"),
	@Result(name = "login", location =  "/WEB-INF/jsp/aigou/admin/login/login.jsp"),
	
})
public class UserAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private IUserService userservice ;
	
	@Action(value = "",results={@Result(name = SUCCESS,location = "/WEB-INF/jsp/aigou/admin/login/login.jsp")})
	public String loginPage(){
		return SUCCESS;	
	}
	
	@Action(value = "/admin/login",results={
			@Result(name = SUCCESS,location = SYS_JSP_BASEURL+"admin/index/index.jsp"),
			@Result(name = ERROR,location = "/WEB-INF/jsp/aigou/admin/login/login.jsp")
			})
	public String login(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User login2 = userservice.login(username);
		if(login2==null){
			return ERROR;
		}
		if(!login2.getPassword().equals(password)){
			return ERROR;	
		}
		return SUCCESS;	
	}
	
	@Action(value="/admin/user/list",results={
			@Result(name = SUCCESS,location = "/WEB-INF/jsp/aigou/admin/user/list.jsp")
	 })
	public String list(){
		HttpServletRequest request = ServletActionContext.getRequest();
		PageModel<User> pageModel = new PageModel<User>();
		pageModel.setPageNo(1);
		pageModel.setPageSize(10);
		
		pageModel = userservice.getUser(pageModel, null);
		request.setAttribute("userPages", pageModel);
		return SUCCESS;
		
	}
	@Action(value = "addPage", results = {
			@Result(name = SUCCESS, location =  "/WEB-INF/jsp/aigou/admin/user/add.jsp")
	})
	public String addPage(){
		return SUCCESS;
	}
	
	/**
	 * 用户添加方法
	 * @return
	 */
	@Action(value = "add", results = {
			@Result(name = "close", location = "/WEB-INF/jsp/aigou/success.jsp")
			})
	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user2 = userservice.login(userName);
		System.out.println("userName");
		if (user2!=null) {
			request.setAttribute("errMsg", "用户已存在");
			return ERROR;
		}
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		user.setType(-1);
		userservice.save(user);
		request.setAttribute("url", "admin/user/list");
		return SYS_ACTION_CLOSE;
	}
	
	/**
	 * 用户修改界面
	 * @return
	 */
	@Action(value = "updatePage", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/jsp/aigou/admin/user/update.jsp")
	})
	public String updatePage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id =  request.getParameter("id");
		User user=userservice.getid(id);
		request.setAttribute("user", user);
		return SUCCESS;
	}
	
	/**
	 * 用户修改方法
	 * @return
	 */
	@Action(value = "update")
	public String update(){
		System.out.println("修改");
		HttpServletRequest request = ServletActionContext.getRequest();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String id = request.getParameter("id");
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		user.setType(-1);
		user.setId(id);
		userservice.update(user);
		request.setAttribute("url", "admin/user/list");
		return SYS_ACTION_CLOSE;
	}
	@Action(value = "delete", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/jsp/aigou/success.jsp")
	})
	public String delete(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		userservice.delete(id);
		request.setAttribute("url", "admin/user/list");
		return SUCCESS;
		
	}
	
}
