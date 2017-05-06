package com.iquizoo.manage.web.product.controller;

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
import com.iquizoo.manage.web.common.Status;
import com.iquizoo.manage.web.product.dto.ProductDto;
import com.iquizoo.manage.web.product.po.Product;
import com.iquizoo.manage.web.product.service.ProductService;

/**
 * 商品
 * 
 * @author Jianxing Wen
 * @date 2016-7-5下午2:01:26
 */
@RequestMapping("product")
@Controller
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;

	/**
	 * 数据列表模型视图
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public ModelAndView productListMV() throws Exception {

		return new ModelAndView("product/product");
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
	public String getTable(DataTable<Product> table) throws Exception {
		DataTable<ProductDto> dtoTable = productService.getTable(table);
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
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public ModelAndView addProductMV(Integer id) throws Exception {
		ModelAndView model = new ModelAndView();
		model.setViewName("product/productAdd");

		List<Status> type = productService.setType();//类型
		List<Status> status = productService.setStatus();//状态
		List<Status> code = productService.setCode();//产品标识
		model.addObject("types", type);
		model.addObject("statuses", status);
		model.addObject("codes", code);
		if (id != null) {
			ProductDto dto = productService.getById(id.intValue());
			model.addObject("product", dto);
		}
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
		productService.addProduct(params);
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
	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public String updateProduct(String params) throws Exception {
		productService.updateProduct(params);
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

		productService.delProduct(id.intValue());
		return success();
	}

}
