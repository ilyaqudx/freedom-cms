package com.iquizoo.manage.web.admin.dao;

import java.util.List;

import com.iquizoo.manage.web.admin.po.Roleownresource;

/**
 * @Description 角色拥有的资源
 * @author GouZhongLiang
 * @date 2016-6-27 上午9:33:45
 */
public interface RoleownresourceDao {

	void addRoleownresource(List<Roleownresource> rs) throws Exception;

	void deleteRoleownresource(Integer roleId) throws Exception;

	List<Roleownresource> getRoleownresourceListByRoleId(Integer roleId) throws Exception;

	void deleteRoleownresourceByRoleId(Integer roleId) throws Exception;

}
