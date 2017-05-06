package com.iquizoo.manage.web.user.service;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.user.AccountDTO;
import com.iquizoo.manage.web.user.po.Account;

public interface AccountService {

	Account getByPhone(String phone) throws Exception;
	String getPhoneById(int id) throws Exception;

	DataTable<AccountDTO> geTable(DataTable<Account> table) throws Exception;
	
}
