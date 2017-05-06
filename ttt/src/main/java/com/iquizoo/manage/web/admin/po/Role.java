package com.iquizoo.manage.web.admin.po;

//Automatically generated, please do not modify		 @author JiangZhiYong

import java.io.Serializable;


public class Role implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * 1-根(最高权限,不对外)
	 * 2-系统管理员(对外最高权限)
	 * 3-普通用户
	 * */
	public static final int TYPE_ROOT = 1,TYPE_SYS = 2,TYPE_COMMON = 3;
	
	/**ID */
	private Integer id;	

	/**角色名称 */
	private String name;	

	/**创建时间 */
	private java.util.Date createTime;	

	/**修改时间 */
	private java.util.Date updateTime;	

	/**描述 */
	private String description;	
	
	private String resourceIds;//资源id
	//角色类型
	private Integer type;
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	/** ID */
	public void setId(Integer id){
		this.id=id;
	}
	
	/** ID */
	public Integer getId(){
		return this.id;
	}
	
	/** 角色名称 */
	public void setName(String name){
		this.name=name;
	}
	
	/** 角色名称 */
	public String getName(){
		return this.name;
	}
	
	/** 创建时间 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	
	/** 创建时间 */
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	
	/** 修改时间 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime=updateTime;
	}
	
	/** 修改时间 */
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}
	
	/** 描述 */
	public void setDescription(String description){
		this.description=description;
	}
	
	/** 描述 */
	public String getDescription(){
		return this.description;
	}
	
	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	@Override
	public String toString() {
		return "Role ["
		+" id="+id
		+" name="+name
		+" createTime="+createTime
		+" updateTime="+updateTime
		+" description="+description
		+ "]";
	}

}