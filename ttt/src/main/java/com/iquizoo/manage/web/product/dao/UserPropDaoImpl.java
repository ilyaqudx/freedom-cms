package com.iquizoo.manage.web.product.dao;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.dao.BasicDAOImpl;
import com.iquizoo.manage.web.product.po.UserProp;


@Repository
public class UserPropDaoImpl extends BasicDAOImpl<UserProp> implements UserPropDao{

	@SuppressWarnings("unchecked")
	@Override
	public DataTable<UserProp> getTable(DataTable<UserProp> table)
			throws Exception {
		return queryTable(table, "UserProp.getList");
	}

	@Override
	public UserProp getByUidPid(UserProp userProp) throws Exception {
		return getSqlSession().selectOne("UserProp.getByUidPid", userProp);
	}


}
