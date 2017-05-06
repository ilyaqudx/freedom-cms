package com.iquizoo.core.api;

public class Consts extends com.iquizoo.core.constants.Consts{

	/**
	 * 游客注册
	 */
	public static final int REG_TYPE_VISITOR = 1;
	/**
	 * 获取手机验证码类型
	 * 1-手机注册
	 * 2-修改密码
	 * 3-游客绑定手机
	 * */
	public static final int 
			PHONE_VERIFICATION_CODE_TYPE_REGISTER = 1, 
			PHONE_VERIFICATION_CODE_TYPE_MODIFY_PASSWORD = 2,
			PHONE_VERIFICATION_VISITOR_BIND_PHONE = 3;
	
	/**
	 * AES加密KEY
	 * */
	public static final String ENCRYPT_AES_KEY = "com.iquizoo.web2";
	/**
	 * 存入SESSION中的KEY
	 * */
	public static final String ENCRYPT_KEY = "encrypt_key";
	
	/**
	 * 请求消息类型：推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * 事件类型：subscribe(订阅)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型：unsubscribe(取消订阅)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	
	public static final String num2Word(int num)
	{
		if(num == 1)
			return "一";
		else if(num == 2)
			return "二";
		else if(num == 3)
			return "三";
		else if(num == 4)
			return "四";
		return "一";
	}
}
