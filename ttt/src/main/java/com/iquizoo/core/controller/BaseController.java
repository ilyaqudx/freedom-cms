package com.iquizoo.core.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;

@Controller
public class BaseController {

	private static final ThreadLocal<HttpServletRequest> threadRequest = new ThreadLocal<HttpServletRequest>();
	private static final ThreadLocal<HttpServletResponse> threadResponse = new ThreadLocal<HttpServletResponse>();
	
	public void setContext(HttpServletRequest request,
			HttpServletResponse response) {
		threadResponse.set(response);
		threadRequest.set(request);
	}
	
	public HttpServletRequest getRequest() {
		return threadRequest.get();
	}
	
	public HttpServletResponse getResponse() {
		return threadResponse.get();
	}
	
	protected String success() throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg", "success");
		map.put("code", "0");
		return JSON.toJSONString(map);
	}

	protected String error(String msg) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg", msg);
		map.put("code", 1);
		return JSON.toJSONString(map);
	}
}
