package com.iquizoo.manage.web.product.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.dao.mybatis.BaseDAO;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.product.po.ProductOrder;

/**
 * 商品订单
 * @author Jianxing Wen
 * @date 2016-7-6下午2:15:21
 */
@Repository
public class ProductOrderDaoImpl extends BaseDAO implements ProductOrderDao{

	@SuppressWarnings("unchecked")
	@Override
	public DataTable<ProductOrder> getTable(DataTable<ProductOrder> table)
			throws Exception {
		return queryTable(table, "ProductOrder.getList");
	}

	@Override
	public List<ProductOrder> getList(Map<String, Object> args) throws Exception {
		return getSqlSession().selectList("ProductOrder.getAllList", args);
	}

	@Override
	public ProductOrder getById(int id) throws Exception {
		return getSqlSession().selectOne("ProductOrder.get", id);
	}

	@Override
	public void addProductOrder(ProductOrder order) throws Exception {
		getSqlSession().insert("ProductOrder.insert", "order");
	}

	@Override
	public void updateProductOrder(ProductOrder order) throws Exception {
		getSqlSession().update("ProductOrder.update", order);
	}

	@Override
	public void delProductOrder(int id) throws Exception {
		getSqlSession().delete("ProductOrder.delete", id);
	}

}
