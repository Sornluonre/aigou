package com.bailiban.aigou.constants;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.bailiban.aigou.constants.Constants;
import com.opensymphony.xwork2.ActionSupport;

@Results({
	@Result(name = "error", location = Constants.SYS_JSP_BASEURL + "admin/500.jsp"),
	@Result(name = "login", location = Constants.SYS_JSP_BASEURL + "admin/login/login.jsp"),
	@Result(name = "close", location = Constants.SYS_JSP_BASEURL + "success.jsp")
})
public class BaseAction extends ActionSupport {
	
	protected static final String SYS_ACTION_CLOSE = "close";
	
	protected static final String SYS_JSP_BASEURL = "/WEB-INF/jsp/aigou/";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int pageNo = 1;
	
	private int pageSize = 10;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		if (StringUtils.isEmpty(pageNo)) {
			pageNo = "1";
		}
		this.pageNo = Integer.parseInt(pageNo);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		if (StringUtils.isEmpty(pageSize)) {
			pageSize = "10";
		}
		this.pageSize = Integer.parseInt(pageSize);
	}
	
	
}
