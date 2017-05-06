package com.iquizoo.manage.web.user.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquizoo.manage.web.common.service.BasicServiceImpl;
import com.iquizoo.manage.web.user.dao.LineUserDAO;
import com.iquizoo.manage.web.user.po.LineUser;

@Service
public class LineUserServiceImpl extends BasicServiceImpl<LineUser> implements LineUserService{

	@Autowired
	private LineUserDAO dao;
	@Override
	public List<LineUser> getByParams(LineUser lineUser) throws Exception {
		return dao.getByParams(lineUser);
	}
	@Override
	public List<String> getSchools() throws Exception {
		return dao.getSchools();
	}

}