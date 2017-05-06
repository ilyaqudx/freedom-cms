package com.iquizoo.manage.web.user.po;

import java.io.Serializable;
//Automatically generated, please do not modify		 @author JiangZhiYong
import java.util.Date;


public class Usermessage implements Serializable{
	private static final long serialVersionUID = 1L;

		
	private Integer id;	

	/**0:纯消息*/
	private Integer type;	

		
	private Integer userId;	

		
	private String attachment;	

		
	private String title;	

		
	private String content;	

		
	private Integer status;	

		
	private Date createTime;	

		
	private Date readTime;	

	/**系统消息id */
	private Integer parentId;	
	
	
	public void setId(Integer id){
		this.id=id;
	}
	
	
	public Integer getId(){
		return this.id;
	}
	
	
	public void setType(Integer type){
		this.type=type;
	}
	
	
	public Integer getType(){
		return this.type;
	}
	
	
	public void setUserId(Integer userId){
		this.userId=userId;
	}
	
	
	public Integer getUserId(){
		return this.userId;
	}
	
	
	public void setAttachment(String attachment){
		this.attachment=attachment;
	}
	
	
	public String getAttachment(){
		return this.attachment;
	}
	
	
	public void setTitle(String title){
		this.title=title;
	}
	
	
	public String getTitle(){
		return this.title;
	}
	
	
	public void setContent(String content){
		this.content=content;
	}
	
	
	public String getContent(){
		return this.content;
	}
	
	
	public void setStatus(Integer status){
		this.status=status;
	}
	
	
	public Integer getStatus(){
		return this.status;
	}
	
	
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	
	
	public Date getCreateTime(){
		return this.createTime;
	}
	
	
	public void setReadTime(Date readTime){
		this.readTime=readTime;
	}
	
	
	public Date getReadTime(){
		return this.readTime;
	}
	
	/** 系统消息id */
	public void setParentId(Integer parentId){
		this.parentId=parentId;
	}
	
	/** 系统消息id */
	public Integer getParentId(){
		return this.parentId;
	}
	
	@Override
	public String toString() {
		return "Usermessage ["
		+" id="+id
		+" type="+type
		+" userId="+userId
		+" attachment="+attachment
		+" title="+title
		+" content="+content
		+" status="+status
		+" createTime="+createTime
		+" readTime="+readTime
		+" parentId="+parentId
		+ "]";
	}

}