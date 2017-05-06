package com.iquizoo.manage.web.product.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.dao.mybatis.BaseDAO;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.product.po.Product;

/**
 * 商品
 * @author Jianxing Wen
 * @date 2016-7-5上午11:35:47
 */
@Repository
public class ProductDaoImpl extends BaseDAO implements ProductDao{

	@SuppressWarnings("unchecked")
	@Override
	public DataTable<Product> getTable(DataTable<Product> table)
			throws Exception {
		return queryTable(table, "Product.getProductList");
	}

	@Override
	public Product getById(int id) throws Exception {
		return getSqlSession().selectOne("Product.getById", id);
	}

	@Override
	public void addProduct(Product product) throws Exception {
		getSqlSession().insert("Product.insert", product);
	}

	@Override
	public void updateProduct(Product product) throws Exception {
		getSqlSession().update("Product.update", product);
		
	}

	@Override
	public void delProduct(int id) throws Exception {
		getSqlSession().delete("Product.delete", id);
	}

	@Override
	public List<Product> getList() throws Exception {
		
		return getSqlSession().selectList("Product.getProductList");
	}

}
