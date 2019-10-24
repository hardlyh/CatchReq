package com.req.entity;

import java.util.HashMap;

/**
 * 存储对象
 * @author liyuhui
 *
 */
public class ReqDto {
	
	private String targetUrl;
	
	private String targetMethod;
	
	private String mehtod;
	
	private HashMap<String,String> paramMap;
	
	private HashMap<String,String> headersMap;
	
	public ReqDto() {
		super();
	}

	public ReqDto(String targetUrl, String targetMethod, String mehtod, HashMap<String, String> paramMap, HashMap<String, String> headersMap) {
		super();
		this.targetUrl = targetUrl;
		this.targetMethod = targetMethod;
		this.mehtod = mehtod;
		this.paramMap = paramMap;
		this.headersMap = headersMap;
	}

	public String getMehtod() {
		return mehtod;
	}

	public void setMehtod(String mehtod) {
		this.mehtod = mehtod;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public String getTargetMethod() {
		return targetMethod;
	}

	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}

	public HashMap<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(HashMap<String, String> paramMap) {
		this.paramMap = paramMap;
	}

	public HashMap<String, String> getHeadersMap() {
		return headersMap;
	}

	public void setHeadersMap(HashMap<String, String> headersMap) {
		this.headersMap = headersMap;
	}
	
	
	
	

}
