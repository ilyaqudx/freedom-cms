package com.iquizoo.manage.web.admin.po;

//Automatically generated, please do not modify		 @author JiangZhiYong

import java.io.Serializable;


public class Adminownrole implements Serializable{
	private static final long serialVersionUID = 1L;

	/**管理员id */
	private Integer adminId;	

	/**角色id */
	private Integer roleId;	
	
	/** 管理员id */
	public void setAdminId(Integer adminId){
		this.adminId=adminId;
	}
	
	/** 管理员id */
	public Integer getAdminId(){
		return this.adminId;
	}
	
	/** 角色id */
	public void setRoleId(Integer roleId){
		this.roleId=roleId;
	}
	
	/** 角色id */
	public Integer getRoleId(){
		return this.roleId;
	}
	
	@Override
	public String toString() {
		return "Adminownrole ["
		+" adminId="+adminId
		+" roleId="+roleId
		+ "]";
	}

}