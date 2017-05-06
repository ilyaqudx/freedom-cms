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
import com.iquizoo.manage.web.product.dto.ProductOrderDto;
import com.iquizoo.manage.web.product.po.ProductOrder;
import com.iquizoo.manage.web.product.service.ProductOrderService;

/**
 * 商品订单
 * @author Jianxing Wen
 * @date 2016-7-6下午1:48:33
 */
@RequestMapping("order")
@Controller
public class ProductOrderController extends BaseController {
	
	@Autowired
	private ProductOrderService orderService;

	/**
	 * 数据列表模型视图
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public ModelAndView productOrderMV() throws Exception {

		return new ModelAndView("product/productOrder");
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
	public String getTable(DataTable<ProductOrder> table) throws Exception { 
		DataTable<ProductOrderDto> dtoTable = orderService.getTable(table);
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
	@RequestMapping(method = RequestMethod.GET, value = "/edit")
	public ModelAndView addProductMV(Integer id) throws Exception {
		ModelAndView model = new ModelAndView();
		model.setViewName("product/orderEdit");	
		List<Status> statusList = orderService.getStatus();
		model.addObject("statusList", statusList);
	    ProductOrder order = orderService.getById(id.intValue());
	    model.addObject("order", order);
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
	@RequestMapping(method = RequestMethod.POST, value = "/edit")
	public String updateProduct(ProductOrder order) throws Exception {
		orderService.updateProductOrder(order);
		return success();
	}


}
