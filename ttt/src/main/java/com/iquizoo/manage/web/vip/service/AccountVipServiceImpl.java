package com.iquizoo.manage.web.vip.service;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.service.BasicServiceImpl;
import com.iquizoo.manage.web.user.po.Account;
import com.iquizoo.manage.web.user.po.User;
import com.iquizoo.manage.web.user.service.AccountService;
import com.iquizoo.manage.web.user.service.UserService;
import com.iquizoo.manage.web.vip.dao.AccountVipDao;
import com.iquizoo.manage.web.vip.dto.AccountVipDTO;
import com.iquizoo.manage.web.vip.po.AccountVip;

@Service
public class AccountVipServiceImpl extends BasicServiceImpl<AccountVip> implements AccountVipService{

	@Autowired
	private AccountVipDao dao;
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserService userService;
	@Autowired
	private AccountVipLogService accountVipLogService;
	@Override
	public DataTable<AccountVipDTO> getTable(DataTable<AccountVip> dataTable) throws Exception {

		String phone = (String) dataTable.getParams().get("phone");
		if(phone != null){
			// 查找账号
			Account account = accountService.getByPhone(phone);
			if(account != null){
				dataTable.getParams().put("accountId", account.getId());
			}
		}

		// 根据accountID查询
		List<AccountVip> list = dao.geTable(dataTable).getData();
		DataTable<AccountVipDTO> dtoTable = new DataTable<AccountVipDTO>();
		BeanUtils.copyProperties(dataTable, dtoTable, "data");
		for(AccountVip accountVip : list){
			AccountVipDTO dto = new AccountVipDTO();
		    BeanUtils.copyProperties(accountVip, dto);
		    phone = accountService.getPhoneById(accountVip.getAccountId());
		    if(phone != null && phone != ""){
		    	dto.setPhone(phone);
		    }
		    User user = userService.getById(accountVip.getUserId());
		    if(user != null){
		    	dto.setName(user.getName());
		    }
		    dtoTable.getData().add(dto);
		}
		return dtoTable;
	}

	@Override
	public AccountVip getByAccountId(int accountId) throws Exception {
		return dao.getByAccountId(accountId);
	}
	
}