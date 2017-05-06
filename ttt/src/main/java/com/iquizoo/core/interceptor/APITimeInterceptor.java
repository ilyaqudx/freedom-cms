package com.iquizoo.core.interceptor;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;

import com.iquizoo.core.annotation.DisableDebug;
import com.iquizoo.core.config.Config;
import com.iquizoo.core.interceptor.handler.Handler;
import com.iquizoo.core.kit.LogKit;

public class APITimeInterceptor extends AbstractInterceptor {

	public APITimeInterceptor() 
	{
		super(new Handler() {

			Logger logger = Logger.getLogger(APITimeInterceptor.class);
			
			@Override
			public boolean preCheck(HttpServletRequest request,
					HttpServletResponse response, HandlerMethod method,
					Annotation annotation) throws Exception 
			{
				String key   = method.getBeanType().getName() + "." + method.getMethod().getName();
				if(null == method.getMethodAnnotation(DisableDebug.class)){
					request.setAttribute(key, System.currentTimeMillis());
					LogKit.info(key + " : startTime : " + (System.currentTimeMillis()),APITimeInterceptor.class);
				}
				return true;
			}

			@Override
			public void afterCheck(HttpServletRequest request,
					HttpServletResponse response, HandlerMethod method,
					Annotation annotation) throws Exception 
			{
				String key = method.getBeanType().getName() + "." + method.getMethod().getName();
				if(null == method.getMethodAnnotation(DisableDebug.class)){
					long startTime = (Long) request.getAttribute(key);
					logger.info(key + " : " + (System.currentTimeMillis() - startTime));
				}
			}
		});
	}

}
