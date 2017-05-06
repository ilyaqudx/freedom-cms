package com.iquizoo.core.api;

public enum JedisKey {

	/**
	 * 游戏对应能力列表("game_abilityList",300)
	 * */
	GAME_ABILITYLIST("game_abilityList",300),
	/**
	 * 帐号登陆令牌前缀(account_token)
	 * */
	ACCOUNT_TOKEN_PREFIX("account_token",3600*24),
	/**
	 * 用户令牌前缀(user_token)
	 * */
	USER_TOKEN_PREFIX("user_token",3600*24),
	
	/**
	 * 微信用户令牌前缀(user_wxToken)
	 */
	WX_TOKEN_PREFIX("user_wxToken",7200),
	/**
	 * 微信用户令牌前缀(user_wxToken)
	 */
	WX_OPENID_PREFIX("user_openId",7200),
	/**
	 * 线下，所有学校集合
	 */
	LINE_SCHOOLS_PREFIX("line_schools",7200),
	/**
	 * 家长控制登陆TOKEN,10分钟
	 * */
	PARENT_CTRL_TOKEN_PREFIX("parent_ctrl_token",600);
	
	public String key;
	public int expire;
	
	JedisKey(String key,int expire)
	{
		this.key = key;
		this.expire = expire;
	}
}
