package com.iquizoo.manage.web.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.iquizoo.core.controller.BaseController;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.user.po.User;
import com.iquizoo.manage.web.user.service.UserService;

@RequestMapping("/deletedUser")
@Controller
public class DeletedUserController extends BaseController{

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value="/list")
	public ModelAndView list() throws Exception{
		return new ModelAndView("user/deletedUser-list");
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/list")
	@ResponseBody
	public String list(DataTable<User> dataTable) throws Exception{
		userService.deletedList(dataTable);
		return JSON.toJSONString(dataTable);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/restore")
	@ResponseBody
	public String restore(Integer userId) throws Exception{
		userService.restore(userId);
		return success();
	}
}
