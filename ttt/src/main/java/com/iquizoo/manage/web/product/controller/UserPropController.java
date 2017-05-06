package com.iquizoo.manage.web.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.iquizoo.core.controller.BaseController;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.product.po.GoldChangeLog;
import com.iquizoo.manage.web.product.po.UserProp;
import com.iquizoo.manage.web.product.service.GoldChangeLogService;
import com.iquizoo.manage.web.product.service.UserPropService;

@RequestMapping(value = "userProp")
@Controller
public class UserPropController extends BaseController {

	@Autowired
	private UserPropService userPropService;
	@Autowired
	private GoldChangeLogService changeLogService;

	/**
	 * 数据列表模型视图
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public ModelAndView productListMV() throws Exception {

		return new ModelAndView("product/userProp");
	}

	/**
	 * 数据列表
	 * 
	 * @param table
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/list")
	public String getTable(DataTable<UserProp> table) throws Exception {
		DataTable<UserProp> dtoTable = userPropService.getTable(table);
		return JSON.toJSONString(dtoTable);
	}

	/**
	 * 添加或修改的模型视图
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = {"/add","/edit"})
	public ModelAndView addProductMV(UserProp userProp) throws Exception {
		ModelAndView model = new ModelAndView();
		if(userProp != null){
			UserProp userP = userPropService.getByUidPid(userProp);
			
			model.addObject("userProp",userP);
		}
		model.setViewName("product/userPropEdit");
		
		return model;
	}

	/**
	 * 修改方法
	 * 
	 * @param proDto
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String addProduct(String params) throws Exception {
		UserProp prop = JSON.parseObject(params, UserProp.class);
		userPropService.insert(prop);
		return success();
	}
	/**
	 * 修改方法
	 * 
	 * @param proDto
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/edit")
	public String updateProduct(String params) throws Exception {
		
		UserProp prop = JSON.parseObject(params, UserProp.class);
		userPropService.update(prop);
		// 添加日志
		int changeGold = prop.getCount() - prop.getOriginalCount();
		GoldChangeLog log = new GoldChangeLog();
		log.setUserId(prop.getUserId());
		log.setEvent(GoldChangeLog.EVENT_HAND);
		log.setChangeGold(changeGold);
		log.setUserGold(prop.getOriginalCount());
		log.setDescription(prop.getUserId()+"手动更改栗子数:"+changeGold);
		changeLogService.insert(log);
		
		return success();
	}
}
