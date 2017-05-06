package com.iquizoo.manage.web.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.dao.mybatis.BaseDAO;
import com.iquizoo.manage.web.user.po.Usermessage;

@Repository
public class UserMessageDaoImpl extends BaseDAO implements UserMessageDao{

	@Override
	public void addUsermessage(List<Usermessage> msgs) throws Exception {
		for (Usermessage msg : msgs) {
			getSqlSession().insert("addUsermessage", msg);
		}
	}

}
