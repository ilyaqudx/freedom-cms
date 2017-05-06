package com.iquizoo.manage.web.product.dao;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.dao.BasicDAO;
import com.iquizoo.manage.web.product.po.Prop;

/**
 * 道具
 * @author Jianxing Wen
 * @date 2016-8-26下午3:23:45
 */
public interface PropDao extends BasicDAO<Prop> {

	DataTable<Prop> getTable(DataTable<Prop> table) throws Exception;
	
}
