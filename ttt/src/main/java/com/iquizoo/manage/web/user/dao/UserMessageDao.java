package com.iquizoo.manage.web.user.dao;

import java.util.List;

import com.iquizoo.manage.web.user.po.Usermessage;

/**
 * @Description 用户消息
 * @author GouZhongLiang
 * @date 2016-7-5 上午11:54:51
 */
public interface UserMessageDao {

	void addUsermessage(List<Usermessage> msgs) throws Exception;

}
