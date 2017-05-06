package com.iquizoo.manage.web.vip.service;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.service.BasicService;
import com.iquizoo.manage.web.vip.dto.AccountVipDTO;
import com.iquizoo.manage.web.vip.po.AccountVip;
/**
 * 会员期限
 * @author Jianxing Wen
 * @date 2016年12月5日下午4:41:05
 *
 */
public interface AccountVipService extends BasicService<AccountVip>{

	/**
	 * 数据
	 */
	DataTable<AccountVipDTO> getTable(DataTable<AccountVip> dataTable) throws Exception;

	//int insert(AccountVip accountVip) throws Exception;

	AccountVip getByAccountId(int accountId) throws Exception;
}
