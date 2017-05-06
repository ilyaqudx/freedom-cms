package com.iquizoo.manage.web.user.dao;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.dao.BasicDAOImpl;
import com.iquizoo.manage.web.user.po.Account;

@Repository
public class AccountDaoImpl extends BasicDAOImpl<Account> implements AccountDao{

	@Override
	public Account getByPhone(String phone) throws Exception {
		return getSqlSession().selectOne("Account.getIdByPhone", phone);
	}

	@Override
	public String getPhoneById(int id) throws Exception {
		return getSqlSession().selectOne("Account.getPhoneById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public DataTable<Account> geTable(DataTable<Account> table) throws Exception {
		return queryTable(table, "Account.getList");
	}


}
