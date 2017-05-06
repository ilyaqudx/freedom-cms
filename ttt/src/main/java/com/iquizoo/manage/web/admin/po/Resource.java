package com.iquizoo.manage.web.admin.po;

//Automatically generated, please do not modify		 @author JiangZhiYong

import java.io.Serializable;


public class Resource implements Serializable{
	private static final long serialVersionUID = 1L;

	/**ID */
	private Integer id;	

	/**父节点id */
	private Integer parentId;	

	/**名称 */
	private String name;	

	/**地址 */
	private String url;	

	/**状态1：可用；0不可用 */
	private Integer status;	

	/**描述 */
	private String description;	

	/**是否记录日志1是，0否 */
	private Integer log;	

	/**是否权限控制1是0否 */
	private Integer authority;	
	
	/**图标*/
	private String icon;
	
	/**类型*/
	private Integer type;
	
	/** ID */
	public void setId(Integer id){
		this.id=id;
	}
	
	/** ID */
	public Integer getId(){
		return this.id;
	}
	
	/** 父节点id */
	public void setParentId(Integer parentId){
		this.parentId=parentId;
	}
	
	/** 父节点id */
	public Integer getParentId(){
		return this.parentId;
	}
	
	/** 名称 */
	public void setName(String name){
		this.name=name;
	}
	
	/** 名称 */
	public String getName(){
		return this.name;
	}
	
	/** 地址 */
	public void setUrl(String url){
		this.url=url;
	}
	
	/** 地址 */
	public String getUrl(){
		return this.url;
	}
	
	/** 状态1：可用；0不可用 */
	public void setStatus(Integer status){
		this.status=status;
	}
	
	/** 状态1：可用；0不可用 */
	public Integer getStatus(){
		return this.status;
	}
	
	/** 描述 */
	public void setDescription(String description){
		this.description=description;
	}
	
	/** 描述 */
	public String getDescription(){
		return this.description;
	}
	
	/** 是否记录日志1是，0否 */
	public void setLog(Integer log){
		this.log=log;
	}
	
	/** 是否记录日志1是，0否 */
	public Integer getLog(){
		return this.log;
	}
	
	/** 是否权限控制1是0否 */
	public void setAuthority(Integer authority){
		this.authority=authority;
	}
	
	/** 是否权限控制1是0否 */
	public Integer getAuthority(){
		return this.authority;
	}
	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Resource ["
		+" id="+id
		+" parentId="+parentId
		+" name="+name
		+" url="+url
		+" status="+status
		+" description="+description
		+" log="+log
		+" authority="+authority
		+ "]";
	}

}