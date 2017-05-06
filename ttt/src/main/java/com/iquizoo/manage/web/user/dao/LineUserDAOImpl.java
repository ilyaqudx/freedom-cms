package com.iquizoo.manage.web.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iquizoo.manage.web.common.dao.BasicDAOImpl;
import com.iquizoo.manage.web.user.po.LineUser;

@Repository
public class LineUserDAOImpl extends BasicDAOImpl<LineUser> implements LineUserDAO{

	@Override
	public List<LineUser> getByParams(LineUser lineUser) throws Exception {
		return getSqlSession().selectList("LineUser.getByParams", lineUser);
	}

	@Override
	public List<String> getSchools() throws Exception {
		return getSqlSession().selectList("LineUser.getSchools");
	}


}
