package com.iquizoo.manage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iquizoo.core.controller.BaseController;
import com.iquizoo.manage.web.admin.service.AdminService;
import com.iquizoo.manage.web.system.service.SystemLogService;

/**
 * @Description TODO
 * @author GouZhongLiang
 * @date 2016-6-13 下午4:11:45
 */
@Controller
public class IndexController extends BaseController{
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private SystemLogService systemLogService;
	
	@RequestMapping("/")
	public ModelAndView index() throws Exception{
		return new ModelAndView("redirect:/main");
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/login")
	public ModelAndView login() throws Exception{
		return new ModelAndView("login");
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	@ResponseBody
	public String login(String name, String password) throws Exception{
		boolean login;
		try {
			login = adminService.login(name,password);
			if(login){
				systemLogService.addLoginLog();
				return success();
			}
		} catch (Exception e) {
			if(e instanceof IllegalArgumentException)
				return error(e.getMessage());
		}
		return error("登陆失败");
	}
	
	@RequestMapping("/main")
	public ModelAndView main() throws Exception{
		return new ModelAndView("index");
	}
}
