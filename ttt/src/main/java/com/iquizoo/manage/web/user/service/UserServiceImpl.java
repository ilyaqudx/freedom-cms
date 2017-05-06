package com.iquizoo.manage.web.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquizoo.core.kit.Kit;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.user.dao.UserDao;
import com.iquizoo.manage.web.user.dto.UserDTO;
import com.iquizoo.manage.web.user.po.Account;
import com.iquizoo.manage.web.user.po.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Autowired
	private AccountService accountService;

	@Override
	public void list(DataTable<User> dataTable) throws Exception {
		String phone = (String) dataTable.getParams().get("phone");
		// 查询号码
		if(phone != null){
			Account account = accountService.getByPhone(phone);
			if(account != null){
				dataTable.getParams().put("accountId", account.getId());
			}
		}
		userDao.getUserList(dataTable);
		List<User> users = dataTable.getData();
		for(User user : users){
			// 查询电话
		   String phone1 = accountService.getPhoneById(user.getAccountId());
		   user.setPhone(phone1);
		}
	}

	@Override
	public void stopUser(Integer userId) throws Exception {
		User user = userDao.getUserById(userId);
		user.setStatus(1);
		userDao.updateUser(user);
	}

	@Override
	public void startUser(Integer userId) throws Exception {
		User user = userDao.getUserById(userId);
		user.setStatus(0);
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(Integer userId) throws Exception {
		User user = userDao.getUserById(userId);
		user.setStatus(4);
		userDao.updateUser(user);
	}

	@Override
	public void updatePass(Integer userId, String pass) throws Exception {
		User user = userDao.getUserById(userId);
		user.setPassword(Kit.md5(pass));
		userDao.updateUser(user);
	}

	@Override
	public void deletedList(DataTable<User> dataTable) throws Exception {
		userDao.getDeletedUserList(dataTable);
	}

	@Override
	public void restore(Integer userId) throws Exception {
		User user = userDao.getUserById(userId);
		user.setStatus(0);
		userDao.updateUser(user);
	}

	@Override
	public User getById(int userId) throws Exception {
		
		return userDao.getUserById(userId);
	}

	@Override
	public User getByNameAndAccountId(String name, int accountId) throws Exception {
		User user = new User();
		user.setName(name);
		user.setAccountId(accountId);
		return userDao.getNameAndAccountId(user);
	}

	@Override
	public User getByAccountId(int accountId) throws Exception {
		return userDao.getByAccountId(accountId);
	}

	@Override
	public List<User> getByParams(UserDTO user) throws Exception {
		return userDao.getByParams(user);
	}

	@Override
	public List<User> getByCreateTime(UserDTO userDTO) throws Exception {
		return userDao.getByCreateTime(userDTO);
	}
	
}