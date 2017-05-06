package com.iquizoo.core.interceptor;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iquizoo.core.interceptor.handler.Handler;

/**抽象拦截器
 * 1-Class<? extends Annotation> annotationClass 可指定相应注解进行拦截
 * 2-Handler interceptorHandler 拦截器业务处理器
 * @author m00056
 *
 */
public class AbstractInterceptor implements HandlerInterceptor {

	protected Class<? extends Annotation> annotationClass;
	protected Handler interceptorHandler;
	
	/**
	 * @param interceptorHandler 拦截器业务处理器
	 */
	public AbstractInterceptor(Handler interceptorHandler)
	{
		this(null,interceptorHandler);
	}
	
	/**
	 * @param annotationClass	对特定注解进行拦截,如果为null表示任何请求都进行拦截
	 * @param interceptorHandler	拦截器业务处理器
	 */
	public AbstractInterceptor(Class<? extends Annotation> annotationClass,Handler interceptorHandler)
	{
		if(interceptorHandler == null)
			throw new NullPointerException("interceptorHandler is null");
		this.annotationClass = annotationClass;
		this.interceptorHandler = interceptorHandler;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception 
	{
		if(handler instanceof HandlerMethod)
		{
			HandlerMethod method = (HandlerMethod) handler;
			if(null == annotationClass)
				return interceptorHandler.preCheck(request,response,method,null);
			else
			{
				Annotation annotation = method.getMethodAnnotation(annotationClass);
				if(null != annotation)
					return interceptorHandler.preCheck(request,response,method,annotation);
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception 
	{
		if(handler instanceof HandlerMethod)
		{
			HandlerMethod method = (HandlerMethod) handler;
			if(null == annotationClass)
				interceptorHandler.afterCheck(request, response, method, null);
			else
			{
				Annotation annotation = method.getMethodAnnotation(annotationClass);
				if(null != annotation)
					interceptorHandler.afterCheck(request, response, method, annotation);
			}
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception 
	{
		
	}

}
