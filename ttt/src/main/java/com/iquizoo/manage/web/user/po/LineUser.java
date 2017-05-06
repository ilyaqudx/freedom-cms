package com.iquizoo.manage.web.user.po;

import java.util.Date;

/**
 * 线下用户
 * @author Jianxing_Wen
 * @date 2016-8-29下午12:37:51
 */
public class LineUser {

	private int userId;// ID
	private String name;// 姓名
	private String gender;// 性别
	private Date birthday;// 生日
	private String classes;// 班级
	private String grades;//  年级
	private String schools;// 学校
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getGrades() {
		return grades;
	}
	public void setGrades(String grades) {
		this.grades = grades;
	}
	public String getSchools() {
		return schools;
	}
	public void setSchools(String schools) {
		this.schools = schools;
	}
	@Override
	public String toString() {
		return "LineUser["+"userId="+userId+",classes="+classes+",grades="+grades+",schools="+schools+"]";
	}
}
