package com.iquizoo.manage.web.admin.service;

import java.util.List;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.base.dto.Tree;
import com.iquizoo.manage.base.dto.ZTree;
import com.iquizoo.manage.web.admin.po.Resource;

/**
 * @Description 资源服务
 * @author GouZhongLiang
 * @date 2016-6-25 下午2:29:24
 */
public interface ResourceService {

	/**
	 * 得到资源列表
	 * @param map
	 * @return
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-25 下午2:48:41
	 */
	public List<Resource> getResourceList() throws Exception;
	
	/**
	 * 得到资源树
	 * @return
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-25 下午3:02:38
	 */
	public Tree getResourceTree(Integer roleId) throws Exception;
	
	/**
	 * 加载所有资源
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-25 下午2:49:13
	 */
	public void loadAllResource() throws Exception;

	public List<ZTree> getZtreeData(Integer id) throws Exception;

	public List<Resource> getResourceByPid(Integer pId) throws Exception;

	public void getResourceList(DataTable<Resource> table) throws Exception;

	public void addResource(Resource resource) throws Exception;

	public void deleteResource(Integer id) throws Exception;

	public Resource getResourceById(Integer id) throws Exception;

	public void editResource(Resource resource) throws Exception;

	public List<Resource> getResourceCategory() throws Exception;

	public void updateCache() throws Exception;
}
