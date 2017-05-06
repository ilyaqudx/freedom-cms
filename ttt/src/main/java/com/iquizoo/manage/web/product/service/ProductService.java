package com.iquizoo.manage.web.product.service;

import java.util.List;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.Status;
import com.iquizoo.manage.web.product.dto.ProductDto;
import com.iquizoo.manage.web.product.po.Product;

/**
 * 商品
 * @author Jianxing Wen
 * @date 2016-7-5上午11:40:58
 */
public interface ProductService {

	/**
	 * 数据 列表
	 * @param table
	 * @return
	 * @throws Exception
	 */
	DataTable<ProductDto> getTable(DataTable<Product> table) throws Exception;
	
	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	List<ProductDto> getList() throws Exception;
	/**
	 * 类型（1-会员 2-栗子）
	 * @return
	 * @throws Exception
	 */
	List<Status> setType() throws Exception;
	/**
	 * 状态（1-正常，2-下架）
	 * @return
	 * @throws Exception
	 */
	List<Status> setStatus() throws Exception;
	/**
	 * 产品标识（1-VIP，0-栗子）
	 * @return
	 * @throws Exception
	 */
	List<Status> setCode() throws Exception;
	/**
	 * 根据ID查询
	 * @param productDto
	 * @return
	 * @throws Exception
	 */
	ProductDto getById(int id) throws Exception;
	/**
	 * 添加
	 * @param productDto
	 * @throws Exception
	 */
	void addProduct(String params) throws Exception;
	/**
	 * 修改
	 * @param productDto
	 * @throws Exception
	 */
	void updateProduct(String params) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	void delProduct(int id) throws Exception;
}
