package com.iquizoo.manage.web.user.po;

import java.io.Serializable;
//Automatically generated, please do not modify		 @author JiangZhiYong
import java.util.Date;


public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	public static final int TYPE_VIP = 1,TYPE_ORDINARY = 2;
		
	private long id;	

		
	private String name;	

	/**性别 */
	private Integer gender;	

		
	private String head;	

		
	private Date birthday;	

	/**帐号ID */
	private Integer accountId;	

	/**是否为管理员(0-否，1-是) */
	private Integer admin;	

	/**成员类型(1-注册成员，2-游客) */
	private Integer type;	

	/**唯一设备号(注册时使用的设备) */
	private String imei;	

	/**推送id(android) */
	private String clientId;	

	/**推送ID(ios) */
	private String deviceToken;	

	/**创建时间 */
	private Date createTime;	

	/**状态(0-正常) */
	private Integer status;	

	/**是否新手(0-否，1-是) */
	private Integer novice;	

	/**手机号 */
	private String phone;	

		
	private String password;	

	/**用户金币 */
	private Integer gold;	

	/**首充状态(0-否,1-是) */
	private Integer firstPay;	
	
	
	public void setId(long id){
		this.id=id;
	}
	
	
	public long getId(){
		return this.id;
	}
	
	
	public void setName(String name){
		this.name=name;
	}
	
	
	public String getName(){
		return this.name;
	}
	
	/** 性别 */
	public void setGender(Integer gender){
		this.gender=gender;
	}
	
	/** 性别 */
	public Integer getGender(){
		return this.gender;
	}
	
	
	public void setHead(String head){
		this.head=head;
	}
	
	
	public String getHead(){
		return this.head;
	}
	
	
	public void setBirthday(Date birthday){
		this.birthday=birthday;
	}
	
	
	public Date getBirthday(){
		return this.birthday;
	}
	
	/** 帐号ID */
	public void setAccountId(Integer accountId){
		this.accountId=accountId;
	}
	
	/** 帐号ID */
	public Integer getAccountId(){
		return this.accountId;
	}
	
	/** 是否为管理员(0-否，1-是) */
	public void setAdmin(Integer admin){
		this.admin=admin;
	}
	
	/** 是否为管理员(0-否，1-是) */
	public Integer getAdmin(){
		return this.admin;
	}
	
	/** 成员类型(1-注册成员，2-游客) */
	public void setType(Integer type){
		this.type=type;
	}
	
	/** 成员类型(1-注册成员，2-游客) */
	public Integer getType(){
		return this.type;
	}
	
	/** 唯一设备号(注册时使用的设备) */
	public void setImei(String imei){
		this.imei=imei;
	}
	
	/** 唯一设备号(注册时使用的设备) */
	public String getImei(){
		return this.imei;
	}
	
	/** 推送id(android) */
	public void setClientId(String clientId){
		this.clientId=clientId;
	}
	
	/** 推送id(android) */
	public String getClientId(){
		return this.clientId;
	}
	
	/** 推送ID(ios) */
	public void setDeviceToken(String deviceToken){
		this.deviceToken=deviceToken;
	}
	
	/** 推送ID(ios) */
	public String getDeviceToken(){
		return this.deviceToken;
	}
	
	/** 创建时间 */
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	
	/** 创建时间 */
	public Date getCreateTime(){
		return this.createTime;
	}
	
	/** 状态(0-正常，1-停用，4-删除) */
	public void setStatus(Integer status){
		this.status=status;
	}
	
	/** 状态(0-正常，1-停用，4-删除) */
	public Integer getStatus(){
		return this.status;
	}
	
	/** 是否新手(0-否，1-是) */
	public void setNovice(Integer novice){
		this.novice=novice;
	}
	
	/** 是否新手(0-否，1-是) */
	public Integer getNovice(){
		return this.novice;
	}
	
	/** 手机号 */
	public void setPhone(String phone){
		this.phone=phone;
	}
	
	/** 手机号 */
	public String getPhone(){
		return this.phone;
	}
	
	
	public void setPassword(String password){
		this.password=password;
	}
	
	
	public String getPassword(){
		return this.password;
	}
	
	/** 用户金币 */
	public void setGold(Integer gold){
		this.gold=gold;
	}
	
	/** 用户金币 */
	public Integer getGold(){
		return this.gold;
	}
	
	/** 首充状态(0-否,1-是) */
	public void setFirstPay(Integer firstPay){
		this.firstPay=firstPay;
	}
	
	/** 首充状态(0-否,1-是) */
	public Integer getFirstPay(){
		return this.firstPay;
	}
	
	@Override
	public String toString() {
		return "User ["
		+" id="+id
		+" name="+name
		+" gender="+gender
		+" head="+head
		+" birthday="+birthday
		+" accountId="+accountId
		+" admin="+admin
		+" type="+type
		+" imei="+imei
		+" clientId="+clientId
		+" deviceToken="+deviceToken
		+" createTime="+createTime
		+" status="+status
		+" novice="+novice
		+" phone="+phone
		+" password="+password
		+" gold="+gold
		+" firstPay="+firstPay
		+ "]";
	}

}