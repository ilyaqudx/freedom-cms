package com.iquizoo.manage.web.vip.dao;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.dao.BasicDAO;
import com.iquizoo.manage.web.vip.po.AccountVip;

/**
 * 会员期间
 * @author Jianxing Wen
 * @date 2016年12月5日下午4:43:40
 *
 */
public interface AccountVipDao extends BasicDAO<AccountVip>{

	DataTable<AccountVip> geTable(DataTable<AccountVip> table) throws Exception;
	AccountVip getByAccountId(Integer accountId) throws Exception;

}
