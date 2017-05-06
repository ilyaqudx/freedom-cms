package com.iquizoo.manage.web.admin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquizoo.core.kit.Kit;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.core.page.Page;
import com.iquizoo.manage.base.context.AppContext;
import com.iquizoo.manage.web.admin.dao.AdminDao;
import com.iquizoo.manage.web.admin.dao.AdminownroleDao;
import com.iquizoo.manage.web.admin.dao.ResourceDao;
import com.iquizoo.manage.web.admin.po.Admin;
import com.iquizoo.manage.web.admin.po.Adminownrole;
import com.iquizoo.manage.web.admin.po.Resource;

/**
 * @Description 管理员
 * @author GouZhongLiang
 * @date 2016-6-14 上午9:31:38
 */
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AdminownroleDao adminownroleDao;
	
	@Autowired
	private ResourceDao resourceDao;
	
	@Override
	public Page list(Page page) throws Exception {
		adminDao.getAdminList(page);
		return page;
	}

	@Override
	public void data(DataTable table) throws Exception {
		adminDao.getAdminList(table);
	}

	@Override
	public Admin getAdminById(Integer id) throws Exception {
		Admin admin = adminDao.getAdminById(id);
		List<Adminownrole> roles = adminownroleDao.getAdminownroleByAdminId(id);
		List<Integer> roleIds = new ArrayList<Integer>();
		for(Adminownrole role : roles){
			roleIds.add(role.getRoleId());
		}
		admin.set_roleIds(roleIds);
		return admin;
	}

	@Override
	public void addAdmin(Admin admin) throws Exception {
		admin.setPassword(Kit.md5(admin.getPassword()));
		admin.setCreateTime(new Date());
		admin.setUpdateTime(new Date());
		admin.setStatus(1);
		adminDao.addAdmin(admin);
		//添加管理员角色
		List<Integer> roleIds = admin.get_roleIds();
		List<Adminownrole> objs = new ArrayList<Adminownrole>();
		for(Integer roleId : roleIds){
			Adminownrole obj = new Adminownrole();
			obj.setAdminId(admin.getId());
			obj.setRoleId(roleId);
			objs.add(obj);
		}
		adminownroleDao.addAdminownrole(objs);
	}

	@Override
	public void updateAdmin(Admin admin) throws Exception {
		admin.setUpdateTime(new Date());
		//更新管理员
		adminDao.updateAdmin(admin);
		//删除管理员的角色
		adminownroleDao.deleteAdminownroleByAdminId(admin.getId());
		//添加管理员角色
		List<Integer> roleIds = admin.get_roleIds();
		List<Adminownrole> objs = new ArrayList<Adminownrole>();
		for(Integer roleId : roleIds){
			Adminownrole obj = new Adminownrole();
			obj.setAdminId(admin.getId());
			obj.setRoleId(roleId);
			objs.add(obj);
		}
		adminownroleDao.addAdminownrole(objs);
	}

	@Override
	public void deleteAdmin(Integer id) throws Exception {
		//删除管理员
		adminDao.deleteAdminByKey(id);
		//删除对应的角色
		adminownroleDao.deleteAdminownroleByAdminId(id);
	}

	@Override
	public void stop(Integer id) throws Exception {
		Admin admin = adminDao.getAdminById(id);
		admin.setStatus(0);
		adminDao.updateAdmin(admin);
	}

	@Override
	public void start(Integer id) throws Exception {
		Admin admin = adminDao.getAdminById(id);
		admin.setStatus(1);
		adminDao.updateAdmin(admin);
	}

	@Override
	public boolean login(String name, String password) throws Exception {
		Admin admin = adminDao.getAdminByName(name);
		if(admin != null){
			if(admin.getStatus() == 1 && Kit.md5(password).equals(admin.getPassword())){
				//缓存权限信息
				AppContext.setAdmin(admin);
				List<Adminownrole> roles = adminownroleDao.getAdminownroleByAdminId(admin.getId());
				Set<String> all = new HashSet<String>();
				for(Adminownrole role : roles){
					List<Resource> resources = resourceDao.getResourceByRoleId(role.getRoleId());
					for(Resource r : resources){
						all.add(r.getUrl());
					}
				}
				AppContext.setAuthority(all);
				return true;
			}
		}
		return false;
	}

	@Override
	public void updateAdminPass(Admin admin) throws Exception {
		admin.setPassword(Kit.md5(admin.getPassword()));
		adminDao.updateAdmin(admin);
	}

}
