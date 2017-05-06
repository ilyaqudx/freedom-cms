package com.iquizoo.manage.web.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.iquizoo.core.controller.BaseController;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.base.dto.ZTree;
import com.iquizoo.manage.web.admin.po.Resource;
import com.iquizoo.manage.web.admin.service.ResourceService;

/**
 * @Description 权限
 * @author GouZhongLiang
 * @date 2016-6-24 下午5:58:35
 */
@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController{
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public ModelAndView main() throws Exception{
		return new ModelAndView("admin/admin-resource").addObject("pId", 0);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/tree", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object treeDate(Integer id) throws Exception{
		//得到ztree数据
		List<ZTree> list = resourceService.getZtreeData(id);
		return JSON.toJSONString(list);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/list")
	@ResponseBody
	public String ListAll(DataTable<Resource> table) throws Exception{
		resourceService.getResourceList(table);
		return JSON.toJSONString(table);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public ModelAndView add(Integer pId) throws Exception{
		return new ModelAndView("admin/admin-resource-add").addObject("pId", pId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	@ResponseBody
	public String add(String params) throws Exception{
		Resource resource = JSON.parseObject(params, Resource.class);
		resourceService.addResource(resource);
		return success();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/delete")
	@ResponseBody
	public String delete(Integer id) throws Exception{
		resourceService.deleteResource(id);
		return success();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/edit")
	public ModelAndView edit(Integer id) throws Exception{
		Resource resource = resourceService.getResourceById(id);
		return new ModelAndView("admin/admin-resource-edit").addObject("resource", resource);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/edit")
	@ResponseBody
	public String edit(String params) throws Exception{
		Resource resource = JSON.parseObject(params, Resource.class);
		resourceService.editResource(resource);
		return success();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateCache")
	@ResponseBody
	public String updateCache() throws Exception{
		resourceService.updateCache();
		return success();
	}
}
