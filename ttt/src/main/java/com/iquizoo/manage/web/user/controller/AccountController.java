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
import com.iquizoo.manage.web.user.AccountDTO;
import com.iquizoo.manage.web.user.po.Account;
import com.iquizoo.manage.web.user.service.AccountService;

/**
 * @Description 用户管理
 * @author GouZhongLiang
 * @date 2016-7-5 上午10:35:39
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController{

	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping(method = RequestMethod.GET, value="/list")
	public ModelAndView list() throws Exception{
		return new ModelAndView("user/account-list");
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/list")
	@ResponseBody
	public String list(DataTable<Account> dataTable) throws Exception{
		DataTable<AccountDTO> dtotale = accountService.geTable(dataTable);
		return JSON.toJSONString(dtotale);
	}
	
}
