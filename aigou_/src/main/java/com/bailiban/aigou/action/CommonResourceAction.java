package com.bailiban.aigou.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.bailiban.aigou.config.SystemConfig;
import com.bailiban.aigou.constants.BaseAction;
import com.bailiban.aigou.utils.ResponseBody;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/common")
public class CommonResourceAction extends BaseAction {
	
	@Autowired
	private SystemConfig systemConfig;
	
	private File file;
	
	private String fileName;
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileName;
	}

	public void setFileFileName(String fileName) {
		this.fileName = fileName;
	}
	
	private ResponseBody responseBody;

	public ResponseBody getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(ResponseBody responseBody) {
		this.responseBody = responseBody;
	}

	@Action(value = "upload", results = {
		@Result(name = SUCCESS, type = "json", params = {
			"root", "responseBody"	
		})	
	})
	public String upload(){
		try {
			System.out.println(file);
			System.out.println(fileName);
			String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			File newFile = new File(systemConfig.getFileuploadpath() + UUID.randomUUID().toString() + suffix);
			FileUtils.copyFile(file, newFile);
			
			Map<String, String> map = new HashMap<String, String>();
            map.put("fileName", newFile.getName());				//修改后文件名
            map.put("fileRealName", fileName);		//上传文件名
            responseBody = new ResponseBody();
            responseBody.setData(map);
            
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	private InputStream attachstream;
	
	private String attachname;
	
	public String getAttachname() {
		return attachname;
	}

	public void setAttachname(String attachname) {
		this.attachname = attachname;
	}

	public InputStream getAttachstream() {
		return attachstream;
	}

	public void setAttachstream(InputStream attachstream) {
		this.attachstream = attachstream;
	}

	@Action(value = "getImage", results = {
		@Result(name = SUCCESS, type = "stream", params = {
			"contentType", "image/jpeg",
			"inputName", "attachstream",
			"contentDisposition", "attachment;filename=\"${attachname}\"",
			"bufferSize", "4096"
		})	
	})
	public String getImage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String image = request.getParameter("image");
		
		File file = new File(systemConfig.getFileuploadpath() + image);
		try {
			attachstream = new FileInputStream(file);
			attachname = image;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
