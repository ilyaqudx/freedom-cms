package com.iquizoo.core.interceptor.handler;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;

/**
 * 拦截器处理器(具体拦截逻辑由子类实现)
 * */
public interface Handler {

	/**
	 * 前置拦截
	 * */
	public boolean preCheck(HttpServletRequest request,HttpServletResponse response,HandlerMethod method,Annotation annotation)throws Exception;
	/**
	 * 后置拦截
	 * */
	public void afterCheck(HttpServletRequest request,HttpServletResponse response,HandlerMethod method,Annotation annotation)throws Exception;
}
