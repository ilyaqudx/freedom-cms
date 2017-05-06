package com.iquizoo.manage.web.user.dao;

import java.util.List;

import com.iquizoo.manage.web.common.dao.BasicDAO;
import com.iquizoo.manage.web.user.po.LineUser;
/**
 * 测评用户转称app的用户
 * @author w00093
 *
 */
public interface LineUserDAO extends BasicDAO<LineUser> {

	List<LineUser> getByParams(LineUser lineUser) throws Exception;
	// 获取转换的所有的学校
	List<String> getSchools() throws Exception;
}
