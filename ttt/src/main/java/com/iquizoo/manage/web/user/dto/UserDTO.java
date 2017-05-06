package com.iquizoo.manage.web.user.dto;

import com.iquizoo.manage.web.user.po.User;

public class UserDTO extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String startTime;
	private String endTime;
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
}
