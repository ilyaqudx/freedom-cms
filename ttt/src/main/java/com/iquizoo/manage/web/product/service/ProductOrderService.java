package com.iquizoo.manage.web.product.service;

import java.util.List;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.Status;
import com.iquizoo.manage.web.product.dto.ProductOrderDto;
import com.iquizoo.manage.web.product.po.ProductOrder;

/**
 * 商品订单
 * @author Jianxing Wen
 * @date 2016-7-6下午2:22:35
 */
public interface ProductOrderService {

	/**
	 * 数据 列表
	 * @param table
	 * @return
	 * @throws Exception
	 */
	DataTable<ProductOrderDto> getTable(DataTable<ProductOrder> table) throws Exception;

	/**
	 * 根据ID查询
	 * @param productDto
	 * @return
	 * @throws Exception
	 */
	ProductOrder getById(int id) throws Exception;
	/**
	 * 状态
	 * @return
	 * @throws Exception
	 */
	List<Status> getStatus() throws Exception;
	
	/**
	 * 修改
	 * @param productDto
	 * @throws Exception
	 */
	void updateProductOrder(ProductOrder order) throws Exception;
	

}
