package com.iquizoo.manage.web.system.po;

//Automatically generated, please do not modify		 @author JiangZhiYong

import java.io.Serializable;


public class Category implements Serializable{
	private static final long serialVersionUID = 1L;

		
	private Integer id;	

		
	private String name;	

		
	private String url;	

		
	private String sort;	

		
	private Integer pId;	
	
	
	public void setId(Integer id){
		this.id=id;
	}
	
	
	public Integer getId(){
		return this.id;
	}
	
	
	public void setName(String name){
		this.name=name;
	}
	
	
	public String getName(){
		return this.name;
	}
	
	
	public void setUrl(String url){
		this.url=url;
	}
	
	
	public String getUrl(){
		return this.url;
	}
	
	
	public void setSort(String sort){
		this.sort=sort;
	}
	
	
	public String getSort(){
		return this.sort;
	}
	
	
	public void setPId(Integer pId){
		this.pId=pId;
	}
	
	
	public Integer getPId(){
		return this.pId;
	}
	
	@Override
	public String toString() {
		return "Category ["
		+" id="+id
		+" name="+name
		+" url="+url
		+" sort="+sort
		+" pId="+pId
		+ "]";
	}

}