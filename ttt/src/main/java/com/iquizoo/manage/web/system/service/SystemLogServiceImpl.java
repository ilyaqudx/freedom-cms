package com.iquizoo.manage.web.system.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.base.context.AppContext;
import com.iquizoo.manage.web.admin.po.Admin;
import com.iquizoo.manage.web.system.dao.SystemLogDao;
import com.iquizoo.manage.web.system.po.Systemlog;

@Service
public class SystemLogServiceImpl implements SystemLogService{

	@Autowired
	private SystemLogDao systemLogDao;
	
	@Override
	public void addLogoutLog() throws Exception {
		Admin admin = AppContext.getAdmin();
		Systemlog log = new Systemlog();
		log.setAdminId(admin.getId());
		log.setCreateTime(new Date());
		log.setMessage("退出");
		systemLogDao.addSystemLog(log);
	}

	@Override
	public void addLoginLog() throws Exception {
		Admin admin = AppContext.getAdmin();
		Systemlog log = new Systemlog();
		log.setAdminId(admin.getId());
		log.setCreateTime(new Date());
		log.setMessage("登陆");
		systemLogDao.addSystemLog(log);
	}

	@Override
	public void list(DataTable<Systemlog> table) throws Exception {
		systemLogDao.getSystemlogList(table);
	}
	
}
