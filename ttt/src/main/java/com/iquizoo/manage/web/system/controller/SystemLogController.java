package com.iquizoo.manage.web.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.iquizoo.core.controller.BaseController;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.system.po.Systemlog;
import com.iquizoo.manage.web.system.service.SystemLogService;

/**
 * @Description 系统日志
 * @author GouZhongLiang
 * @date 2016-8-3 上午9:35:20
 */
@RequestMapping("/systemLog")
@Controller
public class SystemLogController extends BaseController{

	@Autowired
	private SystemLogService systemLogService;
	
	@RequestMapping(method = RequestMethod.GET, value="/list")
	public ModelAndView list() throws Exception{
		return new ModelAndView("system/log-list");
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/list")
	@ResponseBody
	public String list(DataTable<Systemlog> table) throws Exception{
		systemLogService.list(table);
		return JSON.toJSONString(table);
	}
}
