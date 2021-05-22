package com.bailiban.aigou.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bailiban.aigou.constants.BaseAction;

@Controller
@Scope("prototype")
@Namespace("/iconfont")
public class IconFontAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action(value="index",results={
			@Result(name = SUCCESS,location = "/static/iconfont/demo_fontclass.html")
	 })
	public String index(){
		 return SUCCESS;
		
	}
}
