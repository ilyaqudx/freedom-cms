package com.iquizoo.manage.web.system.po;

//Automatically generated, please do not modify		 @author JiangZhiYong

import java.io.Serializable;


public class Systemlog implements Serializable{
	private static final long serialVersionUID = 1L;

	/**ID */
	private Integer id;	

	/**操作人员id */
	private Integer adminId;	

	/**消息内容 */
	private String message;	

	/**创建时间 */
	private java.util.Date createTime;	
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/** ID */
	public void setId(Integer id){
		this.id=id;
	}
	
	/** ID */
	public Integer getId(){
		return this.id;
	}
	
	/** 操作人员id */
	public void setAdminId(Integer adminId){
		this.adminId=adminId;
	}
	
	/** 操作人员id */
	public Integer getAdminId(){
		return this.adminId;
	}
	
	/** 消息内容 */
	public void setMessage(String message){
		this.message=message;
	}
	
	/** 消息内容 */
	public String getMessage(){
		return this.message;
	}
	
	/** 创建时间 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	
	/** 创建时间 */
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	
	@Override
	public String toString() {
		return "Systemlog ["
		+" id="+id
		+" adminId="+adminId
		+" message="+message
		+" createTime="+createTime
		+ "]";
	}

}