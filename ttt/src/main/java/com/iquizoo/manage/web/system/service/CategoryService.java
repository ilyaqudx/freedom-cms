package com.iquizoo.manage.web.system.service;

import java.util.List;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.base.dto.ZTree;
import com.iquizoo.manage.web.system.po.Category;

/**
 * @Description 栏目service
 * @author GouZhongLiang
 * @date 2016-7-20 下午3:54:40
 */
public interface CategoryService {

	void list(DataTable<Category> table) throws Exception;

	List<ZTree> tree(Integer id) throws Exception;

}
