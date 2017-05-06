package com.iquizoo.manage.web.user.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.iquizoo.core.controller.BaseController;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.user.po.User;
import com.iquizoo.manage.web.user.service.UserMessageService;
import com.iquizoo.manage.web.user.service.UserService;

/**
 * @Description 用户管理
 * @author GouZhongLiang
 * @date 2016-7-5 上午10:35:39
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMessageService userMessageService;
	
	@RequestMapping(method = RequestMethod.GET, value="/list")
	public ModelAndView list() throws Exception{
		return new ModelAndView("user/user-list");
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/list")
	@ResponseBody
	public String list(DataTable<User> dataTable) throws Exception{
		userService.list(dataTable);
		return JSON.toJSONString(dataTable);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/sendMsg")
	public ModelAndView sendMsg(String userIds) throws Exception{
		return new ModelAndView("user/user-sendMsg").addObject("userIds", userIds);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/sendMsg")
	@ResponseBody
	public String sendMsg(@RequestParam String userIds,@RequestParam String title,@RequestParam String content) throws Exception{
		List<String> s = Arrays.asList(userIds.split(","));
		List<Integer> ids = JSONArray.parseArray(JSON.toJSONString(s), Integer.class);
		userMessageService.addMessage(ids,title,content,0);
		return success();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/stop")
	@ResponseBody
	public String stop(Integer userId) throws Exception{
		userService.stopUser(userId);
		return success();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/start")
	@ResponseBody
	public String start(Integer userId) throws Exception{
		userService.startUser(userId);
		return success();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/delete")
	@ResponseBody
	public String delete(Integer userId) throws Exception{
		userService.deleteUser(userId);
		return success();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/updatePass")
	public ModelAndView updatePass(Integer userId) throws Exception{
		return new ModelAndView("user/user-updatePass").addObject("userId", userId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/updatePass")
	@ResponseBody
	public String updatePass(Integer userId, String pass) throws Exception{
		userService.updatePass(userId,pass);
		return success();
	}
}
