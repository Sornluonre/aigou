package com.bailiban.aigou.utils;


/**
 * json返回结果实体
 * @author Administrator
 *
 */
public class ResponseBody {

	private boolean result = true;
	
	private String message = "操作成功";
	
	private Object data;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;	
	}
	
	
}
