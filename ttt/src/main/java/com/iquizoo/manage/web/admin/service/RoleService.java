package com.iquizoo.manage.web.admin.service;

import java.util.List;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.admin.po.Role;

/**
 * @Description 角色服务
 * @author GouZhongLiang
 * @date 2016-6-24 下午6:11:21
 */
public interface RoleService {

	/**
	 * 得到角色
	 * @param table
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-25 上午9:26:08
	 */
	void getList(DataTable table) throws Exception;

	/**
	 * 添加角色
	 * @param role
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-27 上午9:24:29
	 */
	void addRole(Role role) throws Exception;

	/**
	 * 删除角色
	 * @param id
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-27 下午2:25:13
	 */
	void deleteRole(Integer id) throws Exception;

	/**
	 * 得到角色
	 * @param id
	 * @return
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-27 下午3:32:53
	 */
	Role getRole(Integer id) throws Exception;

	/**
	 * 编辑角色
	 * @param role
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-27 下午4:40:49
	 */
	void editRole(Role role) throws Exception;

	List<Role> getAllRole() throws Exception;

}
