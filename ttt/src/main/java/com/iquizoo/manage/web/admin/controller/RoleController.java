package com.iquizoo.manage.web.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.iquizoo.core.controller.BaseController;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.base.dto.Tree;
import com.iquizoo.manage.web.admin.po.Role;
import com.iquizoo.manage.web.admin.service.ResourceService;
import com.iquizoo.manage.web.admin.service.RoleService;

/**
 * @Description 角色控制器
 * @author GouZhongLiang
 * @date 2016-6-24 下午5:59:27
 */
@RequestMapping("role")
@Controller
public class RoleController extends BaseController{

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping(method = RequestMethod.GET, value="/list")
	public ModelAndView list() throws Exception{
		return new ModelAndView("admin/admin-role");
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/list")
	@ResponseBody
	public String listData(DataTable table) throws Exception{
		roleService.getList(table);
		return JSON.toJSONString(table);
	}
	
	/**
	 * 编辑时需要传id
	 * @param id
	 * @return
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-27 下午4:11:12
	 */
	@RequestMapping(method = RequestMethod.GET, value={"/add","/edit"})
	public ModelAndView add(Integer id) throws Exception{
		//加载所有的资源权限
		Tree resourceTree = resourceService.getResourceTree(id);
		ModelAndView model = new ModelAndView("admin/admin-role-add");
		model.addObject("resources", resourceTree);
		if(id != null){
			Role role = roleService.getRole(id);
			model.addObject("role", role);
		}
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/add")
	@ResponseBody
	public String addRole(String params) throws Exception{
		Role role = JSON.parseObject(params, Role.class);
		roleService.addRole(role);
		return success();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/edit")
	@ResponseBody
	public String editRole(String params) throws Exception{
		Role role = JSON.parseObject(params, Role.class);
		roleService.editRole(role);
		return success();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/delete")
	@ResponseBody
	public String delete(Integer id) throws Exception{
		roleService.deleteRole(id);
		return success();
	}
}
