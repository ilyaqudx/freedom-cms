package com.iquizoo.manage.web.product.dao;

import java.util.List;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.product.po.Product;

/**
 * 商品
 * @author Jianxing Wen
 * @date 2016-7-5上午11:30:24
 */
public interface ProductDao {

	/**
	 * 数据列表
	 * @param table
	 * @return
	 * @throws Exception
	 */
	DataTable<Product> getTable(DataTable<Product> table) throws Exception;
	
	/**
	 * 得到列表
	 * @return
	 * @throws Exception
	 */
	List<Product> getList() throws Exception;
	/**
	 * 根基ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Product getById(int id) throws Exception;
	/**
	 * 添加商品
	 * @param product
	 * @throws Exception
	 */
	void addProduct(Product product) throws Exception;
	
	/** 
	 * 修改商品
	 * @param product
	 * @throws Exception
	 */
	void updateProduct(Product product) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	void delProduct(int id) throws Exception;
}
