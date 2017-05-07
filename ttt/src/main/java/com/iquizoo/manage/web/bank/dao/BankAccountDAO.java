package com.iquizoo.manage.web.bank.dao;

import java.util.List;

import com.iquizoo.manage.web.bank.po.BankAccount;

public interface BankAccountDAO {

	public BankAccount getAccountBankById(int id);
	
	public List<BankAccount> listAccountBankByUserId(int userId);
}
