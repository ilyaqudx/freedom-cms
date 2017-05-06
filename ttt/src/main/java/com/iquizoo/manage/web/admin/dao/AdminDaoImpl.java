package com.iquizoo.manage.web.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.dao.mybatis.BaseDAO;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.core.page.Page;
import com.iquizoo.manage.web.admin.po.Admin;

@Repository
public class AdminDaoImpl extends BaseDAO implements AdminDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAdminList(Page page) throws Exception {
		return queryPage(null, page, "getAdminList").getData();
	}

	@Override
	public int getAdminListCount() throws Exception {
		return (Integer) getSqlSession().selectOne("getAdminListCount");
	}

	@Override
	public List<Admin> getAdminList() throws Exception {
		return getSqlSession().selectList("getAdminList");
	}

	@Override
	public List<Admin> getAdminList(DataTable table) throws Exception {
		return queryTable(table, "getAdminList").getData();
	}

	@Override
	public Admin getAdminById(Integer id) throws Exception {
		return getSqlSession().selectOne("getAdminById", id);
	}

	@Override
	public void addAdmin(Admin admin) throws Exception {
		getSqlSession().insert("addAdmin", admin);
	}

	@Override
	public void deleteAdminByKey(Integer id) throws Exception {
		getSqlSession().delete("deleteAdminByKey", id);
	}

	@Override
	public void updateAdmin(Admin admin) throws Exception {
		getSqlSession().update("updateAdmin", admin);
	}

	@Override
	public Admin getAdminByName(String name) throws Exception {
		return getSqlSession().selectOne("getAdminByName", name);
	}

}
