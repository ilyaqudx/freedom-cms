package com.iquizoo.manage.web.system.dao;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.system.po.Systemlog;

/**
 * @Description 系统日志
 * @author GouZhongLiang
 * @date 2016-8-3 上午10:10:45
 */
public interface SystemLogDao {

	void addSystemLog(Systemlog log) throws Exception;

	void getSystemlogList(DataTable<Systemlog> table) throws Exception;

}
