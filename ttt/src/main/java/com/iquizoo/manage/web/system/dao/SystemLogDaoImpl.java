package com.iquizoo.manage.web.system.dao;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.dao.mybatis.BaseDAO;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.system.po.Systemlog;

@Repository
public class SystemLogDaoImpl extends BaseDAO implements SystemLogDao{

	@Override
	public void addSystemLog(Systemlog log) {
		getSqlSession().insert("Systemlog.addSystemlog", log);
	}

	@Override
	public void getSystemlogList(DataTable<Systemlog> table) throws Exception {
		queryTable(table, "getSystemlogList");
	}

}
