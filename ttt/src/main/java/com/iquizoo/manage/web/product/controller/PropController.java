package com.iquizoo.manage.web.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.iquizoo.core.controller.BaseController;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.product.dto.PropDto;
import com.iquizoo.manage.web.product.po.Prop;
import com.iquizoo.manage.web.product.service.PropService;

/**
 * 道具
 * 
 * @author Jianxing Wen
 * @date 2016-7-5下午2:01:26
 */
@RequestMapping("prop")
@Controller
public class PropController extends BaseController {

	@Autowired
	private PropService propService;

	/**
	 * 数据列表模型视图
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public ModelAndView productListMV() throws Exception {

		return new ModelAndView("product/prop");
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
	public String getTable(DataTable<Prop> table) throws Exception {
		DataTable<PropDto> dtoTable = propService.getTable(table);
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
	public ModelAndView addProductMV(Integer id) throws Exception {
		ModelAndView model = new ModelAndView();
		if(id != null){
			Prop prop = propService.getById(id);
			model.addObject("prop",prop);
		}
		model.setViewName("product/propEdit");
		
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
	public String addProduct(String params,MultipartFile image) throws Exception {
		Prop prop = JSON.parseObject(params, Prop.class);
		// 上传
		String imagePath = propService.upload(image);
		prop.setImage(imagePath);
		propService.insert(prop);
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
	public String updateProduct(String params,MultipartFile image) throws Exception {
		Prop prop = JSON.parseObject(params, Prop.class);
		// 上传
		String imagePath = propService.upload(image);
		prop.setImage(imagePath);
		propService.update(prop);
		return success();
	}

	/**
	 * 删除方法
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/del")
	public String delProduct(Integer id) throws Exception {

		propService.delete(id);
		return success();
	}

}
