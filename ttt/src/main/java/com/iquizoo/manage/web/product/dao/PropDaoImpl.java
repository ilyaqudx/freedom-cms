package com.iquizoo.manage.web.product.dao;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.dao.BasicDAOImpl;
import com.iquizoo.manage.web.product.po.Prop;


@Repository
public class PropDaoImpl extends BasicDAOImpl<Prop> implements PropDao{

	@SuppressWarnings("unchecked")
	@Override
	public DataTable<Prop> getTable(DataTable<Prop> table)
			throws Exception {
		return queryTable(table, "Prop.get");
	}


}
