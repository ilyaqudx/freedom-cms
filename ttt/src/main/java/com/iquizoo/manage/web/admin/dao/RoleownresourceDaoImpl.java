package com.iquizoo.manage.web.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.dao.mybatis.BaseDAO;
import com.iquizoo.manage.web.admin.po.Roleownresource;

@Repository
public class RoleownresourceDaoImpl extends BaseDAO implements RoleownresourceDao{

	@Override
	public void addRoleownresource(List<Roleownresource> rs) throws Exception {
		for(Roleownresource r : rs){
			getSqlSession().insert("addRoleownresource",r);
		}
	}

	@Override
	public void deleteRoleownresource(Integer roleId) throws Exception {
		getSqlSession().delete("deleteRoleownresource", roleId);
	}

	@Override
	public List<Roleownresource> getRoleownresourceListByRoleId(Integer roleId)
			throws Exception {
		return getSqlSession().selectList("getRoleownresourceListByRoleId", roleId);
	}

	@Override
	public void deleteRoleownresourceByRoleId(Integer roleId) throws Exception {
		getSqlSession().delete("deleteRoleownresourceByRoleId", roleId);
	}

}
