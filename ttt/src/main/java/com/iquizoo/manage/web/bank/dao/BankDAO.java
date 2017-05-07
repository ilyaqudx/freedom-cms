package com.iquizoo.manage.web.bank.dao;

import java.util.List;

import com.iquizoo.manage.web.bank.po.Bank;

public interface BankDAO {

	public List<Bank> getBankList();
	
	public Bank getBankById(Integer id);
	
}
