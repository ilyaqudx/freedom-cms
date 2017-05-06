package com.iquizoo.manage.web.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.dao.mybatis.BaseDAO;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.admin.po.Role;

@Repository
public class RoleDaoImpl extends BaseDAO implements RoleDao{

	@Override
	public void getRoleList(DataTable table) throws Exception {
		queryTable(table, "getRoleList");
	}

	@Override
	public Integer addRole(Role role) throws Exception {
		return getSqlSession().insert("addRole", role);
	}

	@Override
	public void deleteRole(Integer id) throws Exception {
		getSqlSession().delete("deleteRole",id);
	}

	@Override
	public Role getRole(Integer id) throws Exception {
		return getSqlSession().selectOne("getRole", id);
	}

	@Override
	public void updateRole(Role role) throws Exception {
		getSqlSession().update("updateRole", role);
	}

	@Override
	public List<Role> getAllRole() throws Exception {
		return getSqlSession().selectList("getAllRole");
	}

}
