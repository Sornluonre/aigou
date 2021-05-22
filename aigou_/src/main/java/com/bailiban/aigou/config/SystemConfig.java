package com.bailiban.aigou.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig {
	
	@Value("${file_upload_path}")
	private String fileuploadpath;

	public String getFileuploadpath() {
		return fileuploadpath;
	}

	public void setFileuploadpath(String fileuploadpath) {
		this.fileuploadpath = fileuploadpath;
	}
	
}
