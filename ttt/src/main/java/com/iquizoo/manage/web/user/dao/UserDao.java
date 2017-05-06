package com.iquizoo.manage.web.user.dao;

import java.util.List;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.user.dto.UserDTO;
import com.iquizoo.manage.web.user.po.User;

/**
 * @Description 用户DAO
 * @author GouZhongLiang
 * @date 2016-7-5 上午10:37:17
 */
public interface UserDao {

	void getUserList(DataTable<User> dataTable) throws Exception;

	User getUserById(Integer userId) throws Exception;

	void updateUser(User user) throws Exception;

	void deleteUserByKey(Integer userId) throws Exception;

	void getDeletedUserList(DataTable<User> dataTable) throws Exception;

	User getNameAndAccountId(User user) throws Exception;
	User getByAccountId(Integer accountId) throws Exception;
	// 根据一些参数
	List<User> getByParams(UserDTO user) throws Exception;
	// 根据创建时间查找
	List<User> getByCreateTime(UserDTO userDTO) throws Exception;
}
