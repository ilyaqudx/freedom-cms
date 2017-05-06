package com.iquizoo.manage.web.admin.po;

//Automatically generated, please do not modify		 @author JiangZhiYong

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSONArray;


public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;

	/**ID */
	private Integer id;	

	/**名称 */
	private String name;	

	/**密码 */
	private String password;	

	/**创建时间 */
	private java.util.Date createTime;	

	/**更新时间 */
	private java.util.Date updateTime;	

	/**描述 */
	private String description;	

		
	private String realName;	

		
	private String phone;	

	/**1正常 0停用*/
	private Integer status;
	
	private List<Integer> _roleIds;//角色id
	
	/** ID */
	public void setId(Integer id){
		this.id=id;
	}
	
	/** ID */
	public Integer getId(){
		return this.id;
	}
	
	/** 名称 */
	public void setName(String name){
		this.name=name;
	}
	
	/** 名称 */
	public String getName(){
		return this.name;
	}
	
	/** 密码 */
	public void setPassword(String password){
		this.password=password;
	}
	
	/** 密码 */
	public String getPassword(){
		return this.password;
	}
	
	/** 创建时间 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	
	/** 创建时间 */
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	
	/** 更新时间 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime=updateTime;
	}
	
	/** 更新时间 */
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
	
	
	public void setRealName(String realName){
		this.realName=realName;
	}
	
	
	public String getRealName(){
		return this.realName;
	}
	
	
	public void setPhone(String phone){
		this.phone=phone;
	}
	
	
	public String getPhone(){
		return this.phone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Integer> get_roleIds() {
		return _roleIds;
	}

	public void set_roleIds(List<Integer> _roleIds) {
		this._roleIds = _roleIds;
	}

	public void set_roleIds(String roleIds) {
		List<Integer> a = JSONArray.parseArray(roleIds, Integer.class);
		this._roleIds = a;
	}

	@Override
	public String toString() {
		return "Admin ["
		+" id="+id
		+" name="+name
		+" password="+password
		+" createTime="+createTime
		+" updateTime="+updateTime
		+" description="+description
		+" realName="+realName
		+" phone="+phone
		+" status="+status
		+ "]";
	}

}