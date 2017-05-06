package com.iquizoo.manage.web.vip.po;

import java.util.Date;

/**
 * 操作会员期限表的日志
 * @author Jianxing Wen
 * @date 2016年12月6日下午1:59:28
 *
 */
public class AccountVipLog {
	
	private int id;
	private int adminId;
	private int accountId;
	private Date createTime;
	private Date startTime;
	private Date endTime;
	private String mark;
	
	public AccountVipLog(int adminId,int accountId,Date createTime,Date startTime,Date endTime,String mark){
		this.adminId = adminId;
		this.accountId = accountId;
		this.createTime = createTime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.mark = mark;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	

}
