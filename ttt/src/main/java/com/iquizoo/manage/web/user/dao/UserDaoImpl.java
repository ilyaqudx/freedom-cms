package com.iquizoo.manage.web.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.dao.mybatis.BaseDAO;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.user.dto.UserDTO;
import com.iquizoo.manage.web.user.po.User;

@Repository
public class UserDaoImpl extends BaseDAO implements UserDao{

	@Override
	public void getUserList(DataTable<User> dataTable) throws Exception {
		queryTable(dataTable, "User.getUserList");
	}

	@Override
	public User getUserById(Integer userId) throws Exception {
		return getSqlSession().selectOne("User.getUserById", userId);
	}

	@Override
	public void updateUser(User user) throws Exception {
		getSqlSession().update("User.updateUser", user);
	}

	@Override
	public void deleteUserByKey(Integer userId) throws Exception {
		getSqlSession().delete("deleteUserByKey", userId);
	}

	@Override
	public void getDeletedUserList(DataTable<User> dataTable) throws Exception {
		queryTable(dataTable, "User.getDeletedUserList");
	}

	@Override
	public User getNameAndAccountId(User user) throws Exception {
		
		return getSqlSession().selectOne("User.getByNameAndAccountId", user);
	}

	@Override
	public User getByAccountId(Integer accountId) throws Exception {
		
		return getSqlSession().selectOne("User.getByAccountId", accountId);
	}

	@Override
	public List<User> getByParams(UserDTO user) throws Exception {
		return getSqlSession().selectList("User.getByParams", user);
	}

	@Override
	public List<User> getByCreateTime(UserDTO userDTO) throws Exception {
		return getSqlSession().selectList("User.getByCeateTime", userDTO);
	}

}
