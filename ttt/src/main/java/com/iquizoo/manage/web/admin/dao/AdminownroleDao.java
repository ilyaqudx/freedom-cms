package com.iquizoo.manage.web.admin.dao;

import java.util.List;

import com.iquizoo.manage.web.admin.po.Adminownrole;

/**
 * @Description 管理员拥有的角色
 * @author GouZhongLiang
 * @date 2016-6-27 上午9:32:47
 */
public interface AdminownroleDao {

	void addAdminownrole(List<Adminownrole> objs) throws Exception;

	void deleteAdminownroleByAdminId(Integer id) throws Exception;

	List<Adminownrole> getAdminownroleByAdminId(Integer id) throws Exception;

}
