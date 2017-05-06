package com.iquizoo.core.constants;

/**
 * 基础常量
 * */
public class Consts {

	public static final int ZERO = 0 ,ONE = 1;
	/**
	 * 客户端类型
	 * 31-安卓设备
	 * 32-ipad设备
	 * 33-PC浏览器
	 * 34-微信客户端 
	 * 35-iphone
	 */
	public static final int CLIENT_ANDROID = 31, 
							CLIENT_IPAD = 32,
							CLIENT_PC  = 33,
							CLIENT_WX  = 34,
							CLIENT_IPHONE = 35;

	/**
	 * false - 0
	 * true  - 1
	 * */
	public static final int TRUE = 1, FALSE = 0;
	/**
	 * 打开 - 1
	 * 关闭 - 0
	 * */
	public static final int ON   = 1, OFF   = 0;

	public static final int ALL = -999;

	/**true  =>> 1
	 * false =>> 0
	 * @param value boolean值
	 * @return 返回boolean值对应的int值
	 */
	public static final int trueOrFalse(boolean value)
	{
		return value ? Consts.TRUE : Consts.FALSE;
	}
}
