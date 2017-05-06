package com.iquizoo.manage.web.system.controller;

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
import com.iquizoo.manage.web.system.po.Category;
import com.iquizoo.manage.web.system.service.CategoryService;

/**
 * @Description 栏目管理
 * @author GouZhongLiang
 * @date 2016-7-20 下午3:43:04
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController{

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET, value="/list")
	public ModelAndView list() throws Exception{
		return new ModelAndView("system/system-category");
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/list")
	@ResponseBody
	public String list(DataTable<Category> table) throws Exception{
		categoryService.list(table);
		return JSON.toJSONString(table);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/tree", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String tree(Integer id) throws Exception{
		List<ZTree> tree = categoryService.tree(id);
		return JSON.toJSONString(tree);
	}
}
