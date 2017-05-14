package freedom.cms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import freedom.cms.annotation.NotPayPassword;
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
			User user = SessionUtils.getUserInSession(request);
			if(user == null){
				response.sendRedirect("/login");
				return false;
			}
			
			NotPayPassword security = method.getMethodAnnotation(NotPayPassword.class);
			if(!"/error".equals(requestPath) && security == null){
				//说明需要输入二级密码才能查看
				if(!user.getPayPassword().equals(SessionUtils.getPayPassword(request))){
					//SESSION中保存当前二级页面需要的页面,当输入成功后则直接跳转到相应页面
					SessionUtils.setAttr(request, SessionUtils.PAY_PASSWORD_VIEW, requestPath);
					response.sendRedirect("/inputPayPwd");
					return false;
				}
			}
			/*List<String> resources = (List<String>) request.getSession().getAttribute("user_resources");
			
			if(null != resources && !resources.contains(requestPath)){
				System.out.println("user have no permission : " + requestPath);
				return false;
			}*/
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView != null){
			User user = (User) modelAndView.getModel().get("user");
			if(user == null){
				modelAndView.addObject("user", SessionUtils.getUserInSession(request));
			}
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}


}
