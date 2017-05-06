package com.iquizoo.manage.web.admin.dao;

import java.util.List;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.admin.po.Role;

/**
 * @Description 角色
 * @author GouZhongLiang
 * @date 2016-6-25 上午9:26:45
 */
public interface RoleDao {

	/**
	 * 得到角色列表
	 * @param table
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-25 上午9:32:02
	 */
	void getRoleList(DataTable table) throws Exception;

	/**
	 * 添加角色
	 * @param role
	 * @return
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-27 上午9:47:25
	 */
	Integer addRole(Role role) throws Exception;

	/**
	 * 删除角色
	 * @param id
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-27 下午2:28:57
	 */
	void deleteRole(Integer id) throws Exception;

	/**
	 * 得到角色
	 * @param id
	 * @return
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-27 下午3:35:25
	 */
	Role getRole(Integer id) throws Exception;

	/**
	 * 编辑角色
	 * @param role
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-27 下午4:44:04
	 */
	void updateRole(Role role) throws Exception;

	List<Role> getAllRole() throws Exception;

}
