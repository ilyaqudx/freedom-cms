package com.iquizoo.manage.web.user.service;

import java.util.List;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.user.dto.UserDTO;
import com.iquizoo.manage.web.user.po.User;

/**
 * @Description 用户服务
 * @author GouZhongLiang
 * @date 2016-7-5 上午10:36:45
 */
public interface UserService {

	/**
	 * 用户数据
	 * @param dataTable
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-7-5 上午11:02:00
	 */
	void list(DataTable<User> dataTable) throws Exception;

	/**
	 * 停用用户
	 * @param userId
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-8-2 上午9:32:02
	 */
	void stopUser(Integer userId) throws Exception;

	void startUser(Integer userId) throws Exception;

	void deleteUser(Integer userId) throws Exception;

	void updatePass(Integer userId, String pass) throws Exception;

	/**
	 * 删除的用户
	 * @param dataTable
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-8-2 下午2:51:54
	 */
	void deletedList(DataTable<User> dataTable) throws Exception;

	/**
	 * 恢复
	 * @param userId
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-8-2 下午3:15:13
	 */
	void restore(Integer userId) throws Exception;
	
	User getById(int userId) throws Exception;

	User getByNameAndAccountId(String name,int accountId) throws Exception;
	User getByAccountId(int accountId) throws Exception;
	List<User> getByParams(UserDTO user) throws Exception;
	//  根据用户的创建时间查找
	List<User> getByCreateTime(UserDTO userDTO) throws Exception;
}
