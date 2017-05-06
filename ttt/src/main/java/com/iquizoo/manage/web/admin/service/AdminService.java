package com.iquizoo.manage.web.admin.service;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.core.page.Page;
import com.iquizoo.manage.web.admin.po.Admin;

/**
 * @Description 管理员
 * @author GouZhongLiang
 * @date 2016-6-14 上午9:31:11
 */
public interface AdminService {

	/**
	 * 得到列表
	 * @param page
	 * @return
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-14 上午9:58:29
	 */
	Page list(Page page) throws Exception;

	/**
	 * 获取数据
	 * @param table
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-15 下午3:33:22
	 */
	void data(DataTable table) throws Exception;

	/**
	 * 得到管理员
	 * @param id
	 * @return
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-27 下午5:06:30
	 */
	Admin getAdminById(Integer id) throws Exception;

	/**
	 * 添加管理员
	 * @param admin
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-29 下午5:19:59
	 */
	void addAdmin(Admin admin) throws Exception;

	void updateAdmin(Admin admin) throws Exception;

	void deleteAdmin(Integer id) throws Exception;

	/**
	 * 停用
	 * @param id
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-7-4 下午4:10:12
	 */
	void stop(Integer id) throws Exception;

	/**
	 * 启用
	 * @param id
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-7-4 下午4:32:14
	 */
	void start(Integer id) throws Exception;

	boolean login(String name, String password) throws Exception;

	void updateAdminPass(Admin admin) throws Exception;

}
