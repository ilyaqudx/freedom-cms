package com.iquizoo.manage.web.admin.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquizoo.core.api.Consts;
import com.iquizoo.core.kit.Kit;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.core.page.Page;
import com.iquizoo.manage.base.context.AppContext;
import com.iquizoo.manage.web.admin.dao.AdminDao;
import com.iquizoo.manage.web.admin.dao.AdminownroleDao;
import com.iquizoo.manage.web.admin.dao.ResourceDao;
import com.iquizoo.manage.web.admin.dao.RoleDao;
import com.iquizoo.manage.web.admin.po.Admin;
import com.iquizoo.manage.web.admin.po.Adminownrole;
import com.iquizoo.manage.web.admin.po.Resource;
import com.iquizoo.manage.web.bank.dao.BankAccountDAO;
import com.iquizoo.manage.web.bank.po.BankAccount;
import com.iquizoo.manage.web.bank.vo.AdminVO;

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
	private RoleDao roleDAO;
	
	@Autowired
	private ResourceDao resourceDao;
	
	@Override
	public Page list(Page page) throws Exception {
		adminDao.getAdminList(page);
		return page;
	}

	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	@Override
	public void data(DataTable table) throws Exception {
		//单独的业务逻辑处理.用户是有推荐人的,超级管理员可以查看所有人,其他人只能看自己的下线.
		Admin admin = AppContext.getAdmin();
		table.getParams().put("parentId", admin.getId());
		/*List<Adminownrole> ars = adminownroleDao.getAdminownroleByAdminId(admin.getId());
		boolean highestAuthority = false;
		for (Adminownrole ar : ars) {
			Role role = roleDAO.getRole(ar.getRoleId());
			if(role.getType() == Role.TYPE_ROOT || role.getType() == Role.TYPE_SYS){
				highestAuthority = true;
				break;
			}
		}
		
		if(!highestAuthority){
			//如果没有最高权限,只能查看自己下线成员
		}*/
		System.out.println(table.getParams());
		List<Admin> adminList = adminDao.getAdminList(table);
		//查询每个用户的绑定的银行卡信息
		List<AdminVO> data = new ArrayList<>();
		for (Admin a : adminList) {
			BankAccount account = bankAccountDAO.getAccountBankByUserId(a.getId());
			AdminVO vo = Kit.copy(a, AdminVO.class);
			if(account != null){
				vo.setAccount(account.getAccount());
				vo.setAccountName(account.getAccountName());
				vo.setBankName(account.getBankName());
				vo.setBankId(account.getBankId());
			}
			data.add(vo);
		}
		table.setData(data);
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
		admin.setParentId(AppContext.getAdmin().getId());
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
	public boolean login(String name, String password) throws Exception 
	{
		Admin admin = adminDao.getAdminByName(name);
		if(admin != null){
			if(admin.getStatus() == Consts.TRUE){
				if(Kit.md5(password).equals(admin.getPassword())){
					//缓存权限信息
					AppContext.setAdmin(admin);
					List<Adminownrole> roles = adminownroleDao.getAdminownroleByAdminId(admin.getId());
					Set<String> all = new HashSet<String>();
					for(Adminownrole role : roles){
						List<Resource> resources = resourceDao.getResourceByRoleId(role.getRoleId());
						for(Resource r : resources){
							all.add(r.getUrl());
						}
						System.out.println(Arrays.toString(all.toArray()));
					}
					AppContext.setAuthority(all);
					return true;
				}
				throw new IllegalArgumentException("密码错误");
			}
			throw new IllegalArgumentException("帐号被锁定,请联系管理员解除锁定!");
		}
		throw new IllegalArgumentException("用户名错误");
	}

	@Override
	public void updateAdminPass(Admin admin) throws Exception {
		admin.setPassword(Kit.md5(admin.getPassword()));
		adminDao.updateAdmin(admin);
	}

}
