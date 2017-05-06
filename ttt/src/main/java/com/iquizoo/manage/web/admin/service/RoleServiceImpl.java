package com.iquizoo.manage.web.admin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.admin.dao.RoleDao;
import com.iquizoo.manage.web.admin.dao.RoleownresourceDao;
import com.iquizoo.manage.web.admin.po.Role;
import com.iquizoo.manage.web.admin.po.Roleownresource;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private RoleownresourceDao roleownresourceDao;
	
	@Override
	public void getList(DataTable table) throws Exception {
		roleDao.getRoleList(table);
	}

	@Override
	public void addRole(Role role) throws Exception {
		role.setCreateTime(new Date());
		role.setUpdateTime(new Date());
		//添加角色
		roleDao.addRole(role);
		//添加角色的资源
		String resourceIds = role.getResourceIds();
		List<Roleownresource> rs = new ArrayList<Roleownresource>();
		if(StringUtils.isNotBlank(resourceIds)){
			String[] objs = resourceIds.split(",");
			int length = objs.length;
			for(int i=0; i<length; i++){
				Roleownresource r = new Roleownresource();
				r.setResourceId(new Integer(objs[i]));
				r.setRoleId(role.getId());
				rs.add(r);
			}
			roleownresourceDao.addRoleownresource(rs);
		}
	}

	@Override
	public void deleteRole(Integer id) throws Exception {
		//删除角色
		roleDao.deleteRole(id);
		//删除角色的权限
		roleownresourceDao.deleteRoleownresource(id);
	}

	@Override
	public Role getRole(Integer id) throws Exception {
		Role role = roleDao.getRole(id);
		return role;
	}

	@Override
	public void editRole(Role role) throws Exception {
		role.setUpdateTime(new Date());
		//编辑角色
		roleDao.updateRole(role);
		//删除角色的资源
		roleownresourceDao.deleteRoleownresourceByRoleId(role.getId());
		//添加角色的资源
		String resourceIds = role.getResourceIds();
		List<Roleownresource> rs = new ArrayList<Roleownresource>();
		if(StringUtils.isNotBlank(resourceIds)){
			String[] objs = resourceIds.split(",");
			int length = objs.length;
			for(int i=0; i<length; i++){
				Roleownresource r = new Roleownresource();
				r.setResourceId(new Integer(objs[i]));
				r.setRoleId(role.getId());
				rs.add(r);
			}
			roleownresourceDao.addRoleownresource(rs);
		}
	}

	@Override
	public List<Role> getAllRole() throws Exception {
		List<Role> roles = roleDao.getAllRole();
		return roles;
	}
}
