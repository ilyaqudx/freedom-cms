package com.iquizoo.manage.web.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.service.BasicServiceImpl;
import com.iquizoo.manage.web.product.dao.UserPropDao;
import com.iquizoo.manage.web.product.po.Prop;
import com.iquizoo.manage.web.product.po.UserProp;
import com.iquizoo.manage.web.user.po.User;
import com.iquizoo.manage.web.user.service.UserService;

@Service
public class UserPropServiceImpl extends BasicServiceImpl<UserProp> implements UserPropService{

	@Autowired
	private UserPropDao userPropDao;
	@Autowired
	private UserService userService;
	@Autowired
	private PropService propService;
	
	@Override
	public DataTable<UserProp> getTable(DataTable<UserProp> table)
			throws Exception {
		table = userPropDao.getTable(table);
		List<UserProp> userProps = table.getData();
		for(UserProp userProp : userProps){
			User user = userService.getById(userProp.getUserId());
			if(user != null){
				userProp.setUserName(user.getName());
			}
			Prop prop = propService.getById(userProp.getPropId());
			if(prop != null){
				userProp.setPropName(prop.getName());
			}
		}
		return table;
	}

	@Override
	public UserProp getByUidPid(UserProp userProp) throws Exception {
		return userPropDao.getByUidPid(userProp);
	}
	

}
