package com.iquizoo.manage.web.product.po;

/**
 * 用户道具表
 * */
public class UserProp {

	private int userId;
	private int propId;
	private int count;
	private String userName;
	private String propName;
	private int originalCount;
	
	
	
	public int getOriginalCount() {
		return originalCount;
	}
	public void setOriginalCount(int originalCount) {
		this.originalCount = originalCount;
	}
	public String getPropName() {
		return propName;
	}
	public void setPropName(String propName) {
		this.propName = propName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserProp change(int v)
	{
		this.count += v;
		return this;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPropId() {
		return propId;
	}
	public void setPropId(int propId) {
		this.propId = propId;
	}
	public int getCount() {
		return count;
	}
	public UserProp setCount(int count) {
		this.count = count;
		return this;
	}
	@Override
	public String toString() {
		return "UserProp [userId=" + userId + ", propId=" + propId + ", count="
				+ count + "]";
	}
}
