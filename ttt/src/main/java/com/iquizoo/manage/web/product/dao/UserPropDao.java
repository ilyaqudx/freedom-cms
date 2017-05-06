package com.iquizoo.manage.web.product.dao;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.dao.BasicDAO;
import com.iquizoo.manage.web.product.po.UserProp;

public interface UserPropDao extends BasicDAO<UserProp>{

	DataTable<UserProp> getTable(DataTable<UserProp> table) throws Exception;
	UserProp getByUidPid(UserProp userProp) throws Exception;
}
