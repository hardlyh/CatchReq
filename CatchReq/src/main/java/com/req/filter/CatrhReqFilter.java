package com.req.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.req.entity.ReqDto;
import com.req.entity.SaveEntity;

/**
 * 捕捉Request内的参数,并且存储到指定的位置
 * @author liyuhui
 *
 */
public class CatrhReqFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("CatrhReqFilter   开始启动");
		HttpServletRequest req = (HttpServletRequest) request;

		HashMap<String, String> headerMap = new HashMap<String, String>();
		HashMap<String, String> paramMap = new HashMap<String, String>();

		String method = req.getMethod();
		StringBuffer url = req.getRequestURL();
		String requestURI = req.getRequestURI();
		
		String[] split = url.toString().split("\\.");

		// 静态资源过滤
		if (split != null && split.length != 0) {
			String string = split[split.length-1];
			if(string.equals("html") ||string.equals("js")||string.equals("css")||string.equals("ico")||string.equals("img")
					||string.equals("jpg")||string.equals("jpeg")||string.equals("map")) {
				chain.doFilter(request, response);
				return ;
			}
		}
		
		// 过滤reqCatchGetAll
		if(url.toString().contains("reqCatchGetAll")) {
			chain.doFilter(request, response);
			return ;
		}

		// 获取header
		Enumeration<String> headerNames = req.getHeaderNames();
		for (Enumeration e = headerNames; e.hasMoreElements();) {

			String headersName = e.nextElement().toString();
			String headersValue = req.getHeader(headersName);
			headerMap.put(headersName, headersValue);
		}

		// 获取 param
		Enumeration<String> paramNames = req.getParameterNames();
		for (Enumeration e = paramNames; e.hasMoreElements();) {
			String paramName = e.nextElement().toString();
			String paramValue = req.getParameter(paramName);
			paramMap.put(paramName, paramValue);
		}

		ReqDto dto = new ReqDto(url.toString(), requestURI, method, paramMap, headerMap);
		SaveEntity mapper = SaveEntity.Instance();
		mapper.save(dto);
		chain.doFilter(request, response);
		System.out.println("CatrhReqFilter   结束");
	}
}
