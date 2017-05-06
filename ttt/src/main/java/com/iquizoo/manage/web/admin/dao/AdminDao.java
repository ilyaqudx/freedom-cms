package com.iquizoo.manage.web.admin.dao;

import java.util.List;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.core.page.Page;
import com.iquizoo.manage.web.admin.po.Admin;

public interface AdminDao {

	List<Admin> getAdminList(Page page) throws Exception;

	int getAdminListCount() throws Exception;

	List<Admin> getAdminList() throws Exception;

	List<Admin> getAdminList(DataTable table) throws Exception;
	
	Admin getAdminById(Integer id) throws Exception;

	void addAdmin(Admin admin) throws Exception;

	void deleteAdminByKey(Integer id) throws Exception;

	void updateAdmin(Admin admin) throws Exception;
	
	Admin getAdminByName(String name) throws Exception;

}
