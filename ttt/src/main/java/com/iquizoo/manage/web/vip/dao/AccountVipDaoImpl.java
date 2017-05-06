package com.iquizoo.manage.web.vip.dao;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.dao.BasicDAOImpl;
import com.iquizoo.manage.web.vip.po.AccountVip;

@Repository
public class AccountVipDaoImpl extends BasicDAOImpl<AccountVip> implements AccountVipDao{

	@SuppressWarnings("unchecked")
	@Override
	public DataTable<AccountVip> geTable(DataTable<AccountVip> table) throws Exception {
		return queryTable(table, "AccountVip.getList");
	}

	@Override
	public AccountVip getByAccountId(Integer accountId) throws Exception {
		return getSqlSession().selectOne("AccountVip.getByAccountId", accountId);
	}

}
