package com.iquizoo.manage.web.user;

import java.io.Serializable;

import com.iquizoo.manage.web.user.po.Account;

public class AccountDTO extends Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String TYPE_VIP ="会员",TYPE_ORDINARY ="游客";
	private String name;// 第一角色的昵称
	private String typeName;// 类型
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	
}
