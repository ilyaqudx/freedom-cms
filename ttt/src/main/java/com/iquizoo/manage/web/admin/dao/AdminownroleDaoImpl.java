package com.iquizoo.manage.web.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.dao.mybatis.BaseDAO;
import com.iquizoo.manage.web.admin.po.Adminownrole;

@Repository
public class AdminownroleDaoImpl extends BaseDAO implements AdminownroleDao{

	@Override
	public void addAdminownrole(List<Adminownrole> objs) throws Exception {
		for(Adminownrole obj : objs){
			getSqlSession().insert("addAdminownrole", obj);
		}
	}

	@Override
	public void deleteAdminownroleByAdminId(Integer id) throws Exception {
		getSqlSession().delete("deleteAdminownroleByAdminId", id);
	}

	@Override
	public List<Adminownrole> getAdminownroleByAdminId(Integer id)
			throws Exception {
		return getSqlSession().selectList("getAdminownroleByAdminId", id);
	}

}
