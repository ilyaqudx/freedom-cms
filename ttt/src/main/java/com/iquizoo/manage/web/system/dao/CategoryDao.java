package com.iquizoo.manage.web.system.dao;

import java.util.List;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.system.po.Category;

/**
 * @Description 栏目DAO
 * @author GouZhongLiang
 * @date 2016-7-20 下午3:53:01
 */
public interface CategoryDao {

	void getCategoryList(DataTable<Category> table) throws Exception;

	List<Category> getAllCategory() throws Exception;

	List<Category> getCategoryByPid(Integer id) throws Exception;

}
