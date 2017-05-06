package com.iquizoo.manage.web.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquizoo.core.dao.mybatis.BaseDAO;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.base.context.AppContext;
import com.iquizoo.manage.base.dto.Tree;
import com.iquizoo.manage.base.dto.ZTree;
import com.iquizoo.manage.web.admin.dao.ResourceDao;
import com.iquizoo.manage.web.admin.dao.RoleownresourceDao;
import com.iquizoo.manage.web.admin.dto.ResourceDTO;
import com.iquizoo.manage.web.admin.po.Resource;
import com.iquizoo.manage.web.admin.po.Roleownresource;

@Service
public class ResourceServiceImpl extends BaseDAO implements ResourceService{
	@Autowired
	private ResourceDao resourceDao;
	
	@Autowired
	private RoleownresourceDao roleownresourceDao;

	@Override
	public Tree getResourceTree(Integer roleId) throws Exception {
		List<Roleownresource> rs = null;
		Set<Integer> resourceIds = new HashSet<Integer>();
		if(roleId != null){
			rs = roleownresourceDao.getRoleownresourceListByRoleId(roleId);
			for(Roleownresource r:rs){
				resourceIds.add(r.getResourceId());
			}
		}
		List<Resource> resourceList = this.getResourceList();
		Tree root = Tree.createRootTree("全部");
		for(int i=0;i <resourceList.size();i++){
			
			Resource re = resourceList.get(i);
			if(re.getParentId() <= 0){
				resourceList.remove(re);
				i=-1;
				int checkState = resourceIds.contains(re.getId()) ? 1 : 0;
				Tree tree = new Tree(re.getId(), re.getName(), re.getId(), true, true, true, checkState, true);
				createTreeNode(tree,resourceList, resourceIds);
				root.addChildNode(tree);
			}
		}
		return root;
	}
	
	@Override
	public List<Resource> getResourceList()
			throws Exception {
		List<Resource> datas = resourceDao.getResourceList();
		return datas;
	}

	private void createTreeNode(Tree tree, List<Resource> resourceList, Set<Integer> resourceIds) throws Exception{
		boolean hasChild = false;
		for(int i=0;i <resourceList.size();i++){
			Resource re = resourceList.get(i);
			if(re.getParentId().intValue() == tree.getId().intValue()){
				resourceList.remove(re);
				i=-1;
				hasChild = true;
				int checkState = resourceIds.contains(re.getId()) ? 1 : 0;
				Tree tr = new Tree(re.getId(), re.getName(), re.getId(), true, true, true, checkState, true);
				createTreeNode(tr, resourceList, resourceIds);
				tree.addChildNode(tr);
			}
		}
		tree.setHasChildren(hasChild);
	}

	@Override
	public void loadAllResource() throws Exception {
		//得到所有资源
		List<Resource> list = resourceDao.getResourceList();
		Map<String,ResourceDTO> dtoMap = new HashMap<String,ResourceDTO>();
		
		Map<Integer, Resource> resourceMap = new HashMap<Integer,Resource>();
		for(Resource re : list){
			resourceMap.put(re.getId(), re);
		}
		for(Resource re : list){
			//如果不可用，就跳过
			if(re.getStatus() == 0){
				continue;
			}
			ResourceDTO dto = new ResourceDTO();
			dto.setDescription(re.getDescription());
			dto.setId(re.getId());
			dto.setName(re.getName());
			if(re.getParentId() > 0){
				Resource parent = resourceMap.get(re.getParentId());
				if(parent != null){
					dto.setParentUrl(parent.getUrl());
				}
			}
			dto.setUrl(re.getUrl());
			dto.setLog(re.getLog());
			dto.setAuthority(re.getAuthority());
			dtoMap.put(re.getUrl(), dto);
		}
		AppContext.setAllResource(dtoMap.keySet());
		AppContext.setResource(dtoMap);
	}

	@Override
	public List<ZTree> getZtreeData(Integer id) throws Exception {
		List<ZTree> trees = new ArrayList<ZTree>();
		List<Resource> resources = null;
		if(id == null){//加载所有
			resources = getResourceList();
			//主目录
			ZTree root = new ZTree();
			root.setId(0);
			root.setPId(-1);
			root.setName("主页");
			root.setOpen(true);
			root.setIsParent(true);
			trees.add(root);
		}else{//加载部分
			resources = resourceDao.getResourceByPid(id);
		}
		for(Resource resource : resources){
			ZTree tree = new ZTree();
			tree.setId(resource.getId());
			tree.setPId(resource.getParentId());
			tree.setName(resource.getName());
			tree.setOpen(false);
			tree.setIsParent(resource.getType() == 1 ? true : false);
			trees.add(tree);
		}
		return trees;
	}

	@Override
	public List<Resource> getResourceByPid(Integer pId) throws Exception {
		return resourceDao.getResourceByPid(pId == null ? 0 : pId);
	}

	@Override
	public void getResourceList(DataTable<Resource> table) throws Exception {
		resourceDao.getResourceList(table);
	}

	@Override
	public void addResource(Resource resource) throws Exception {
		resource.setStatus(1);
		resourceDao.addResource(resource);
	}

	@Override
	public void deleteResource(Integer id) throws Exception {
		resourceDao.deleteResourceById(id);
	}

	@Override
	public Resource getResourceById(Integer id) throws Exception {
		Resource resource = resourceDao.getResourceById(id);
		return resource;
	}

	@Override
	public void editResource(Resource resource) throws Exception {
		resourceDao.updateResource(resource);
	}

	@Override
	public List<Resource> getResourceCategory() throws Exception {
		List<Resource> all = getResourceList();
		List<Resource> sub = new ArrayList<Resource>();
		for(Resource r : all){
			if(r.getType() == 1){
				sub.add(r);
			}
		}
		return sub;
	}

	@Override
	public void updateCache() throws Exception {
		AppContext.setCategory(getResourceCategory());
	}

}
