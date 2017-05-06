package com.iquizoo.manage.web.user.service;

import java.util.List;

import com.iquizoo.manage.web.common.service.BasicService;
import com.iquizoo.manage.web.user.po.LineUser;

public interface LineUserService extends BasicService<LineUser> {

	List<LineUser> getByParams(LineUser lineUser) throws Exception;
	// 获取转换的所有的学校
	List<String> getSchools() throws Exception;
}
