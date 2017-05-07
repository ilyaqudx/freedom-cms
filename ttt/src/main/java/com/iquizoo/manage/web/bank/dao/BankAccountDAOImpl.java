package com.iquizoo.manage.web.bank.dao;

import java.util.List;

import com.iquizoo.core.dao.mybatis.BaseDAO;
import com.iquizoo.manage.web.bank.po.BankAccount;

public class BankAccountDAOImpl extends BaseDAO implements BankAccountDAO {

	@Override
	public BankAccount getAccountBankById(int id) {
		return getSqlSession().selectOne("getAccountBankById",id);
	}

	@Override
	public List<BankAccount> listAccountBankByUserId(int userId) {
		return getSqlSession().selectList("listAccountBankByUserId", userId);
	}

}
