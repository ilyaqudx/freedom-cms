package com.iquizoo.manage.web.user.po;

import java.util.Date;

public class Account {

	private int id;
	private String name;
	private int level = 0;
	private int adminId;
	private int members;
	private int status = 1;
	private String phone;
	private String password;
	private String imei;
	private Date createTime;
	private String qrcode;// 二维码
	private int wx;// 二维码
	private String jcAccount;//捷成登录账号
	
	
	public String getJcAccount() {
		return jcAccount;
	}
	public void setJcAccount(String jcAccount) {
		this.jcAccount = jcAccount;
	}
	public int getWx() {
		return wx;
	}
	public void setWx(int wx) {
		this.wx = wx;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getMembers() {
		return members;
	}
	public void setMembers(int members) {
		this.members = members;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", level=" + level
				+ ", adminId=" + adminId + ", members=" + members
				+ ", createTime=" + createTime + "]";
	}
}
