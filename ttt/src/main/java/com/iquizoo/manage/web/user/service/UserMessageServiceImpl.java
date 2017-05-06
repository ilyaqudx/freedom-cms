package com.iquizoo.manage.web.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquizoo.manage.web.user.dao.UserMessageDao;
import com.iquizoo.manage.web.user.po.Usermessage;

@Service
public class UserMessageServiceImpl implements UserMessageService{

	@Autowired
	private UserMessageDao userMessageDao;
	
	@Override
	public void addMessage(List<Integer> ids, String title, String content,
			int type) throws Exception {
		List<Usermessage> msgs = new ArrayList<Usermessage>();
		Date date = new Date();
		for(Integer id : ids){
			Usermessage msg = new Usermessage();
//			msg.setAttachment("");
			msg.setContent(content);
			msg.setCreateTime(date);
			msg.setParentId(0);
			msg.setStatus(0);
			msg.setTitle(title);
			msg.setType(type);
			msg.setUserId(id);
			msgs.add(msg);
		}
		userMessageDao.addUsermessage(msgs);
	}

}
