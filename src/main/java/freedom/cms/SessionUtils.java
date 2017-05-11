package freedom.cms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public static final Map<Integer,String> VERIFY_CODES = new HashMap<>();
	
	static{
		List<String> codes = Arrays.asList("4947","7846","3616","4252","7997","2970","1182","6912","6115","5439");
		for (int i = 0; i < 10; i++) {
			VERIFY_CODES.put(i, codes.get(i));
		}
	}
	
	
	
	public static final String USER_IN_SESSION = "user_in_session";
	
	public static final String USER_RESOURCE = "user_resources";
	
	public static final String getKaptcha(HttpServletRequest request)
	{
		return (String) getSession(request).getAttribute(Constants.KAPTCHA_SESSION_KEY);
	}
	/**
	 * 手动
	 * */
	public static final void putKaptcha(HttpServletRequest request,String verifyCode)
	{
		getSession(request).setAttribute(Constants.KAPTCHA_SESSION_KEY, verifyCode);
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
