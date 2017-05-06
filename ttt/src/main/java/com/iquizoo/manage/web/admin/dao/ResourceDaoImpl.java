package com.iquizoo.manage.web.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.dao.mybatis.BaseDAO;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.admin.po.Resource;

@Repository
public class ResourceDaoImpl extends BaseDAO implements ResourceDao{

	@Override
	public List<Resource> getResourceList() throws Exception {
		return getSqlSession().selectList("getResourceList");
	}

	@Override
	public List<Resource> getResourceByPid(int pId) throws Exception {
		return getSqlSession().selectList("getResourceByPid", pId);
	}

	@Override
	public void getResourceList(DataTable<Resource> table) throws Exception {
		queryTable(table, "getResourceTableList");
	}

	@Override
	public void addResource(Resource resource) {
		getSqlSession().insert("addResource", resource);
	}

	@Override
	public void deleteResourceById(Integer id) throws Exception {
		getSqlSession().delete("deleteResourceById", id);
	}

	@Override
	public Resource getResourceById(Integer id) throws Exception {
		return getSqlSession().selectOne("getResourceById", id);
	}

	@Override
	public void updateResource(Resource resource) throws Exception {
		getSqlSession().update("updateResource", resource);
	}

	@Override
	public List<Resource> getResourceByRoleId(Integer roleId) throws Exception {
		return getSqlSession().selectList("getResourceByRoleId", roleId);
	}

}
