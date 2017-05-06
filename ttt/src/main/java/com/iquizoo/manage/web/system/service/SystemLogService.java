package com.iquizoo.manage.web.system.service;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.system.po.Systemlog;

/**
 * @Description 系统日志服务
 * @author GouZhongLiang
 * @date 2016-8-3 上午9:38:53
 */
public interface SystemLogService {

	void addLogoutLog() throws Exception;

	void addLoginLog() throws Exception;

	void list(DataTable<Systemlog> table) throws Exception;
}
