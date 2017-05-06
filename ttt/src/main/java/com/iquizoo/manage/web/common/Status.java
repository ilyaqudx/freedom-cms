package com.iquizoo.manage.web.common;

public class Status {

	private int status;
	private String statusName;
	
	public Status() {
	}
	public Status(int status, String statusName) {
		super();
		this.status = status;
		this.statusName = statusName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	@Override
	public String toString(){
		return "Status["+"status="+status+"statusName="+statusName+"]";
	}
}
