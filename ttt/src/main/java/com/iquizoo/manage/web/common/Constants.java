package com.iquizoo.manage.web.common;




public class Constants {

	public static final String TYPE_COMMON="普通测评";
	public static final String TYPE_NOVICE="新手测评";
	
	public static final String TYPE_VIP="会员";
	public static final String TYPE_GOLD="栗子";
	
	public static final String STATUS_NORMAL="正常";
	public static final String STATUS_NOTUSE="下架";
	
	public static final String CODE_VIP="VIP";//产品标识
	public static final String CODE_GOLD="栗子";//产品标识
	
	public static final String STATUS_UNFINISH="进行中";//用户任务
	public static final String STATUS_FINISHED="已完成";
	public static final String STATUS_RECEIVED="已领取";
	
	public static final String ARTICLE_TYPE_SYS = "系统公告";
	public static final String ARTICLE_TYPE_ATV = "活动消息";
	
	public static final int CLIENT_IOS = 32;// 客户端IOS
	public static final int CLIENT_ANDROID =31;// 客户端Android
	//public static final Namespace NS = Namespace.getNamespace("http://schemas.android.com/apk/res/android");
	
	// 老游戏最大编号，新游戏使用新的配置方式和新的日志，关卡，为了兼容老游戏的数据，需要做一个区分
	public static final int MAX_OLD_GAME_CODE = 46;
}
