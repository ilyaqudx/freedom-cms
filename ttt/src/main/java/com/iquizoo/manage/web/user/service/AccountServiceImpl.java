package com.iquizoo.manage.web.user.service;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.user.AccountDTO;
import com.iquizoo.manage.web.user.dao.AccountDao;
import com.iquizoo.manage.web.user.po.Account;
import com.iquizoo.manage.web.user.po.User;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private UserService userService;
	
	@Override
	public Account getByPhone(String phone) throws Exception {
		return accountDao.getByPhone(phone);
	}
	@Override
	public String getPhoneById(int id) throws Exception {
		return accountDao.getPhoneById(id);
	}
	@Override
	public DataTable<AccountDTO> geTable(DataTable<Account> table) throws Exception {
		List<Account> list = accountDao.geTable(table).getData();
		DataTable<AccountDTO> dtotable = new DataTable<AccountDTO>();
		BeanUtils.copyProperties(table, dtotable, "data");
		AccountDTO dto = null;
		for(Account account : list){
			dto = new AccountDTO();
			BeanUtils.copyProperties(account, dto);
			User user = userService.getByAccountId(account.getId());
			if(user != null){
				if(user.getName() != null){
					dto.setName(user.getName());
				}
			}
			if(account.getPhone() == null || account.getPhone().length()<11){
				dto.setTypeName(AccountDTO.TYPE_ORDINARY);
			}else{
				dto.setTypeName(AccountDTO.TYPE_VIP);
			}
			dtotable.getData().add(dto);
		}
		return dtotable;
	}

}