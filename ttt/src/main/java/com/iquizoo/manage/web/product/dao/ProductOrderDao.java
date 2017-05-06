package com.iquizoo.manage.web.product.dao;

import java.util.List;
import java.util.Map;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.product.po.ProductOrder;

/**
 * 商品订单
 * @author Jianxing Wen
 * @date 2016-7-6下午2:11:36
 */
public interface ProductOrderDao {

	/**
	 * 数据列表
	 * @param table
	 * @return
	 * @throws Exception
	 */
	DataTable<ProductOrder> getTable(DataTable<ProductOrder> table) throws Exception;
	
	/**
	 * 得到列表
	 * @return
	 * @throws Exception
	 */
	List<ProductOrder> getList(Map<String, Object> args) throws Exception;
	/**
	 * 根基ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	ProductOrder getById(int id) throws Exception;
	/**
	 * 添加商品
	 * @param product
	 * @throws Exception
	 */
	void addProductOrder(ProductOrder order) throws Exception;
	
	/** 
	 * 修改商品
	 * @param product
	 * @throws Exception
	 */
	void updateProductOrder(ProductOrder order) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	void delProductOrder(int id) throws Exception;
}
