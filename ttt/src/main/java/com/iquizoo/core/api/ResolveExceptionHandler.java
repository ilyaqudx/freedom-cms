package com.iquizoo.core.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.iquizoo.core.validate.ParameterException;

@Component
public class ResolveExceptionHandler implements HandlerExceptionResolver
{

	Logger log = Logger.getLogger(ResolveExceptionHandler.class);

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
	{
		/**
		 * 异常处理向外抛出
		 */
		Map<String, Object> m = new HashMap<String, Object>();
		if (ex instanceof APIException)
		{
			m.put("code", ((APIException) ex).getCode());
			m.put("msg", ((APIException) ex).getMsg());
		} 
		else if(ex instanceof ParameterException)
		{
			m.put("code", APIExceptionCode.PARAMETER_EXCEPTION.code);
			m.put("msg", APIExceptionCode.PARAMETER_EXCEPTION.msg + " [" + ex.getMessage()+"]");
		}
		else
		{
			log.error(ex.getMessage(), ex);
			m.put("code", APIExceptionCode.SERVER_EXCEPTION.code);
			m.put("msg"," [" + ex.getMessage()+"]");
		}
		return new ModelAndView(new JsonView((HandlerMethod)handler), m);
	}

}
