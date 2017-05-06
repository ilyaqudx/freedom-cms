package com.iquizoo.core.api;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.alibaba.fastjson.JSON;
import com.iquizoo.core.kit.Kit;

public class JsonView extends ModelAndView implements View
{

	private HandlerMethod method;
	public JsonView(HandlerMethod method)
	{
		this.method = method;
	}
	
	public String getContentType()
	{
		return "text/html; charset=utf-8";
	}

	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		request.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", getContentType());
		String output = null;
		if (model != null && model.size() > 0)
		{
			// 清理空对象
			Iterator<?> iter = model.entrySet().iterator();
			while (iter.hasNext())
			{
				if (Kit.isNull(((Entry<?, ?>) iter.next()).getValue()))
				{
					iter.remove();
				}
			}
			output = JSON.toJSONString(model);
		}
		// jsonp
		String callback = request.getParameter("callback");
		if (Kit.isNotNull(callback))
		{
			output = callback + "(" + output + ")";
		}
		response.getWriter().write(output);
	}

}
