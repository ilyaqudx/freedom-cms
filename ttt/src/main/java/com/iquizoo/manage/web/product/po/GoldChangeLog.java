package com.iquizoo.manage.web.product.po;

import java.util.Date;

/**
 * 栗子改变日志
 * */
public class GoldChangeLog {

	/**
	 * 改变事件
	 * 1-购买栗子(+)
	 * 2-购买计划(-)
	 * 3-完成日训练(+)
	 * 4-完成计划训练(+)
	 * 5-每日登陆(+)
	 * 6-首次充值购买栗子(+)
	 * 7-突发事件手动更改()
	 * */
	public static final int 
			EVENT_BUY_GOLD = 1,
			EVENT_BUY_PLAN = 2,
			EVENT_FINISH_DAILY_TRAINING = 3,
			EVENT_FINISH_PLAN_TRAINING = 4,
			EVENT_LOGIN = 5,
			EVENT_FIRST_PAY_FOR_GOLD = 6,
	        EVENT_HAND = 7;
	
	private int id;
	private int userId;
	private int event;
	private int changeGold;
	private int userGold;
	private Date createTime = new Date();
	private String description;
	
	public GoldChangeLog(){
		
	}
	public GoldChangeLog(int userId, int event, int changeGold, int userGold,
			String description) {
		this.userId = userId;
		this.event = event;
		this.changeGold = changeGold;
		this.userGold = userGold;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getEvent() {
		return event;
	}
	public void setEvent(int event) {
		this.event = event;
	}
	public int getChangeGold() {
		return changeGold;
	}
	public void setChangeGold(int changeGold) {
		this.changeGold = changeGold;
	}
	public int getUserGold() {
		return userGold;
	}
	public void setUserGold(int userGold) {
		this.userGold = userGold;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "GoldChangeLog [id=" + id + ", userId=" + userId + ", event="
				+ event + ", changeGold=" + changeGold + ", userGold="
				+ userGold + ", createTime=" + createTime + ", description="
				+ description + "]";
	}
}
