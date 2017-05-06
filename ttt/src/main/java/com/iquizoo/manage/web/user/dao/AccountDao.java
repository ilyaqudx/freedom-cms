package com.iquizoo.manage.web.user.dao;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.dao.BasicDAO;
import com.iquizoo.manage.web.user.po.Account;


/**
 * 账号查询
 * @author Jianxing_Wen
 * @date 2016-11-19下午1:49:00
 */
public interface AccountDao extends BasicDAO<Account> {

	Account getByPhone(String phone) throws Exception;
	String  getPhoneById(int id) throws Exception;

	DataTable<Account> geTable(DataTable<Account> table) throws Exception;
}
