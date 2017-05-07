package com.iquizoo.manage.web.bank.po;

public class Bank {

	private Integer id;
	private String  name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + "]";
	} 
}
