package com.iquizoo.manage.base.context;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.iquizoo.manage.web.admin.dto.ResourceDTO;
import com.iquizoo.manage.web.admin.po.Admin;
import com.iquizoo.manage.web.admin.po.Resource;


/**
 * @Description 用户上下文
 * @author GouZhongLiang
 * @date 2015-8-31 下午4:11:32
 */
public class AppContext {

	public static final String ADMIN = "ADMIN";

	public static final String AUTHORITY = "AUTHORITY";

	/** 缓存所有权限 */
	private static Set<String> allResource;
	
	/** 所有的权限*/
	private static Map<String,ResourceDTO> resource;
	
	/**菜单栏目*/
	private static List<Resource> category;

	public static HttpServletRequest getRequest(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request;
	}
	
	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * 得到当前管理员
	 * 
	 * @return
	 * @author GouZhongLiang
	 * @date 2015-8-31 下午4:17:00
	 */
	public static Admin getAdmin() {
		Admin admin = (Admin) getSession().getAttribute(ADMIN);
		return admin;
	}
	
	/**
	 * 得到当前管理员
	 * 
	 * @return
	 * @author GouZhongLiang
	 * @date 2015-8-31 下午4:17:00
	 */
//	public static Integer getCurrentAdminId() {
//		Admin admin = (Admin) getSession().getAttribute(CURRENT_USER);
//		if(admin == null){
//			return null;
//		}
//		return admin.getId();
//	}

	/**
	 * 添加当前管理员
	 * 
	 * @param admin
	 * @author GouZhongLiang
	 * @date 2015-8-31 下午5:31:25
	 */
	public static void setAdmin(Admin admin) {
		getSession().setAttribute(ADMIN, admin);
	}

	/**
	 * 设置用户的权限
	 * 
	 * @param set
	 * @author GouZhongLiang
	 * @date 2015-8-31 下午5:37:21
	 */
	public static void setAuthority(Set<String> set) {
		getSession().setAttribute(AUTHORITY, set);
	}

	@SuppressWarnings("unchecked")
	public static Set<String> getAuthority() {
		return (Set<String>) getSession().getAttribute(AUTHORITY);
	}
	
	public static String getAuthorityJson() {
		return JSON.toJSONString(getSession().getAttribute(AUTHORITY));
	}

	/**
	 * 得到用户属性
	 * @param str KEY
	 * @author GouZhongLiang
	 * @date 2015-8-31 下午5:10:07
	 */
	public static Object getAttribute(String str) {
		return getSession().getAttribute(str);
	}

	/**
	 * 添加属性
	 * @param str KEY
	 * @param obj value
	 * @author GouZhongLiang
	 * @date 2015-8-31 下午5:11:41
	 */
	public static void addAttribute(String str, Object obj) {
		getSession().setAttribute(str, obj);
	}

	public static Set<String> getAllResource() {
		return allResource;
	}

	public static void setAllResource(Set<String> allResource) {
		AppContext.allResource = allResource;
	}

	public static Map<String, ResourceDTO> getResource() {
		return resource;
	}

	public static void setResource(Map<String, ResourceDTO> resource) {
		AppContext.resource = resource;
	}

	public static List<Resource> getCategory() {
		return category;
	}

	public static void setCategory(List<Resource> category) {
		AppContext.category = category;
	}

}
