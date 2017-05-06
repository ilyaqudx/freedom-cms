package com.iquizoo.manage.web.system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.base.dto.ZTree;
import com.iquizoo.manage.web.system.dao.CategoryDao;
import com.iquizoo.manage.web.system.po.Category;

/**
 * @Description 栏目
 * @author GouZhongLiang
 * @date 2016-7-20 下午3:55:03
 */
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public void list(DataTable<Category> table) throws Exception {
		categoryDao.getCategoryList(table);
	}

	@Override
	public List<ZTree> tree(Integer id) throws Exception {
		List<ZTree> tree = new ArrayList<ZTree>();
		List<Category> categorys = null;
		if(id == null){
			categorys = categoryDao.getAllCategory();
		}else{
			categorys = categoryDao.getCategoryByPid(id);
		}
		ZTree root = new ZTree();
		root.setId(0);
		root.setName("主页");
		root.setOpen(true);
		root.setPId(-1);
		tree.add(root);
		for(Category c : categorys){
			ZTree t = new ZTree();
			t.setId(c.getId());
			t.setName(c.getName());
			t.setPId(c.getPId());
			tree.add(t);
		}
		return tree;
	}

}
