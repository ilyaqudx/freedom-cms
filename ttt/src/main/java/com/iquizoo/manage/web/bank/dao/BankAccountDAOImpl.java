package com.iquizoo.manage.web.bank.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.dao.mybatis.BaseDAO;
import com.iquizoo.core.kit.Kit;
import com.iquizoo.manage.web.bank.po.BankAccount;
@Repository
public class BankAccountDAOImpl extends BaseDAO implements BankAccountDAO {

	@Override
	public BankAccount getAccountBankById(int id) {
		return getSqlSession().selectOne("getAccountBankById",id);
	}

	@Override
	public List<BankAccount> listBankAccountByUserId(int userId) {
		return getSqlSession().selectList("listBankAccountByUserId", userId);
	}

	@Override
	public void addBankAccount(BankAccount account) 
	{
		getSqlSession().insert("addBankAccount", account);
	}

	@Override
	public BankAccount getAccountBankByUserId(Integer userId) {
		List<BankAccount> accounts = listBankAccountByUserId(userId);
		return Kit.isBlank(accounts) ? null : accounts.get(0);
	}

	@Override
	public void updateBankAccount(BankAccount account) 
	{
		getSqlSession().update("updateBankAccount", account);
	}

}
