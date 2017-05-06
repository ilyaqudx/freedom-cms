package com.iquizoo.manage.web.product.service;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.service.BasicService;
import com.iquizoo.manage.web.product.po.UserProp;

/**
 * 道具
 * @author Jianxing Wen
 * @date 2016-8-26下午3:47:59
 */
public interface UserPropService extends BasicService<UserProp>{
	
	DataTable<UserProp> getTable(DataTable<UserProp> table) throws Exception;
	UserProp getByUidPid(UserProp userProp) throws Exception;
	
}
