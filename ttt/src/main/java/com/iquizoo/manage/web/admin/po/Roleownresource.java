package com.iquizoo.manage.web.admin.po;

//Automatically generated, please do not modify		 @author JiangZhiYong

import java.io.Serializable;


public class Roleownresource implements Serializable{
	private static final long serialVersionUID = 1L;

	/**角色id */
	private Integer roleId;	

	/**资源id */
	private Integer resourceId;	
	
	/** 角色id */
	public void setRoleId(Integer roleId){
		this.roleId=roleId;
	}
	
	/** 角色id */
	public Integer getRoleId(){
		return this.roleId;
	}
	
	/** 资源id */
	public void setResourceId(Integer resourceId){
		this.resourceId=resourceId;
	}
	
	/** 资源id */
	public Integer getResourceId(){
		return this.resourceId;
	}
	
	@Override
	public String toString() {
		return "Roleownresource ["
		+" roleId="+roleId
		+" resourceId="+resourceId
		+ "]";
	}

}