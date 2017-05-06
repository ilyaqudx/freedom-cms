package freedom.cms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import freedom.cms.domain.User;

/**  
 * 创建时间: 2017年5月4日 下午10:02:47  
 * 项目名称: freedom-cms  
 * @author freedom  
 * @version 1.0   
 * @since JDK 1.8.0_21  
 * 文件名称: SessionUtils.java  
 * 类说明:  
 */
public class SessionUtils {

	public static final String USER_IN_SESSION = "user_in_session";
	
	public static final String USER_RESOURCE = "user_resources";
	
	public static final String getKaptcha(HttpServletRequest request)
	{
		return (String) getSession(request).getAttribute(Constants.KAPTCHA_SESSION_KEY);
	}
	
	public static final void putUserInSession(HttpServletRequest request,User user)
	{
		getSession(request).setAttribute(USER_IN_SESSION, user);
	}
	
	public static final User getUserInSession(HttpServletRequest request)
	{
		return (User) getSession(request).getAttribute(USER_IN_SESSION);
	}
	
	public static final void putUserResourceInSession(HttpServletRequest request,List<String> resources)
	{
		getSession(request).setAttribute(USER_RESOURCE, resources);
	}
	
	@SuppressWarnings("unchecked")
	public static final List<String> getUserResourceInSession(HttpServletRequest request)
	{
		return (List<String>) getSession(request).getAttribute(USER_RESOURCE);
	}
	
	private static final HttpSession getSession(HttpServletRequest request)
	{
		return request.getSession();
	}
}
