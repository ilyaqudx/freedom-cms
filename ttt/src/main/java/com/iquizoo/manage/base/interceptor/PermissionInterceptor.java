package com.iquizoo.manage.base.interceptor;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iquizoo.core.controller.BaseController;
import com.iquizoo.manage.base.context.AppContext;

/**
 * @Description 权限拦截器
 * @author GouZhongLiang
 * @date 2016-6-25 下午4:54:47
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter{

	private Set<String> parameter;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if(!HandlerMethod.class.isInstance(handler)){
			return true;
		}
		HandlerMethod method = (HandlerMethod)handler;
		Object bean = method.getBean();
		if(bean instanceof BaseController){
			((BaseController) bean).setContext(request, response);
		}
		String path = request.getServletPath();
		if(path.equals("/") || parameter.contains(path)){
			return true;
		}
		if(AppContext.getAdmin() == null){
			//跳转到登录页
//			response.sendRedirect(request.getContextPath());
			StringBuilder sb = new StringBuilder();
			sb.append("<script>top.location.href='");
			sb.append(request.getContextPath());
			sb.append("/login");
			sb.append("';</script>");
			response.getWriter().print(sb.toString());
			return false;
		}
		//得到请求的类型，POST|GET
		String type = request.getMethod();
		return super.preHandle(request, response, handler);
	}

	public Set<String> getParameter() {
		return parameter;
	}

	public void setParameter(Set<String> parameter) {
		this.parameter = parameter;
	}

}
