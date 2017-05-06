package freedom.cms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import freedom.cms.annotation.PublicAPI;
import freedom.cms.domain.User;

/**  
 * 创建时间: 2017年5月4日 上午1:25:40  
 * 项目名称: freedom-cms  
 * @author freedom  
 * @version 1.0   
 * @since JDK 1.8.0_21  
 * 文件名称: AuthInterceptor.java  
 * 类说明:  
 */
public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception 
	{
		HandlerMethod method = (HandlerMethod) handler;
		PublicAPI publicAPI = method.getMethodAnnotation(PublicAPI.class);
		if(publicAPI == null){
			String requestPath = request.getRequestURI();
			User user = (User) request.getSession().getAttribute("user_in_session");
			if(user == null){
				response.sendRedirect("/login.html");
				return false;
			}
			List<String> resources = (List<String>) request.getSession().getAttribute("user_resources");
			
			if(null != resources && !resources.contains(requestPath)){
				System.out.println("user have no permission : " + requestPath);
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}


}
