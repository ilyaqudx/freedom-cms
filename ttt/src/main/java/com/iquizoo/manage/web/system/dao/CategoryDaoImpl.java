package com.iquizoo.manage.web.system.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.dao.mybatis.BaseDAO;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.system.po.Category;

/**
 * @Description 栏目dao
 * @author GouZhongLiang
 * @date 2016-7-20 下午3:53:33
 */
@Repository
public class CategoryDaoImpl extends BaseDAO implements CategoryDao{

	@Override
	public void getCategoryList(DataTable<Category> table) throws Exception {
		queryTable(table, "getCategoryList");
	}

	@Override
	public List<Category> getAllCategory() throws Exception {
		return getSqlSession().selectList("getAllCategory");
	}

	@Override
	public List<Category> getCategoryByPid(Integer id) throws Exception {
		return getSqlSession().selectList("getCategoryByPid",id);
	}

}
