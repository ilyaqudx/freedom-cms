package com.iquizoo.manage.web.admin.dao;

import java.util.List;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.admin.po.Resource;

/**
 * @Description 资源
 * @author GouZhongLiang
 * @date 2016-6-25 下午2:28:36
 */
public interface ResourceDao {

	List<Resource> getResourceList() throws Exception;

	List<Resource> getResourceByPid(int pId) throws Exception;

	void getResourceList(DataTable<Resource> table) throws Exception;

	void addResource(Resource resource);

	void deleteResourceById(Integer id) throws Exception;

	Resource getResourceById(Integer id) throws Exception;

	void updateResource(Resource resource) throws Exception;

	List<Resource> getResourceByRoleId(Integer roleId) throws Exception;

}
