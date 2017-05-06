package com.iquizoo.core.api;

public enum APIExceptionCode {

	/**
	 * 服务器内部错误
	 */
	SERVER_EXCEPTION(500, "服务器内部错误"),
	/**
	 * 请求不合法(验证登陆失败)
	 */
	AUTHENTICATION_EXCEPTION(501, "此用户已在其Ta设备上登录"), 
	/**
	 * 参数异常
	 * */
	PARAMETER_EXCEPTION(503,"请求参数不合法"),
	/**
	 * 帐号已存在
	 */
	ACCOUNT_EXISTED(10001, "帐号已存在"),
	/**
	 * 生日不能为空
	 */
	BIRTHDAY_IS_NULL(10002, "生日为空"),
	/**
	 * 用户不存在
	 */
	ACCOUNT_NOT_EXIST(10003, "账号不存在"),
	/**
	 * 请求参数为空
	 */
	PARAMS_IS_NULL(10004, "请求参数为空"),
	/**
	 * 用户已不是新手
	 */
	USER_NOT_NOVICE(10004, "用户已不是新手"),
	/**
	 * 测评计划不存在
	 */
	EVALUATION_PLAN_NOT_EXIST(10005, "测评计划不存在"),
	/**
	 * 基础计划模版不存在
	 */
	PLAN_TEMPLATE_NOT_EXIST(100006, "计划模版不存在"),
	/**
	 * 用户当前没有可用的训练计划
	 */
	USER_NO_TRAINING_PLAN(100007, "当前没有可训练的计划"),
	/**
	 * 获取测评报告异常
	 */
	EVALUATION_REPORT_QUERY_ERROR(100008, "获取测评报告异常"),
	/**
	 * 新手测评获取异常
	 */
	NOVICE_EVALUATION_QUERY_ERROR(100009, "新手测评获取异常"),
	/**
	 * 测评提交异常
	 */
	EVALUATION_SUBMIT_ERROR(100010, "测评提交异常"),
	/**
	 * 测评还未提交
	 */
	EVALUATION_UNFINISH(100011, "测评状态异常"),
	/**
	 * 用户计划不存在
	 */
	PLAN_NOT_EXIST(100012, "用户计划不存在"),
	/**
	 * 当天未包含此游戏
	 */
	PLAN_NOT_CONTAINS_THIS_GAME(100013, "计划未包含此训练"),
	/**
	 * 测评不属于该用户
	 */
	EVALUATION_NOT_OWN_USER(100014, "测评不属于该用户"),
	/**
	 * 此计划已结束
	 */
	PLAN_IS_FINISHED(100015, "此计划已结束"),
	/**
	 * 此计划训练未完成
	 */
	PLAN_TRAINING_NOT_FINISH(100016, "此计划训练未完成"),
	/**
	 * 今日训练已结束
	 */
	PLAN_IS_FINISHED_OF_TODAY(100017, "今日训练已结束"),
	/**
	 * 用户不能训练该计划(未购买)
	 */
	PLAN_NOT_OPENED(100018, "此计划需要购买才能训练"),
	/**
	 * 计划后续训练需要购买
	 */
	PLAN_TRY_FINISH(100019, "计划后续训练需要购买"),
	/**
	 * 手机号无效
	 */
	PHONE_IS_INVALID(100020, "手机号不合法"), 
	/**
	 * 短信验证码间隔太短
	 * */
	PHONE_SMS_TIME_TOO_SHORT(100021, "短信间隔时间太短"),
	/**
	 * 用户名或密码错误
	 */
	ACCOUNT_OR_PASSWORD_ERROR(100022, "用户名或密码错误"),
	/**
	 * 密码错误
	 */
	PASSWORD_ERROR(100023, "密码错误"),
	/**
	 * 验证码校验失败
	 */
	VERIFY_SMS_FAIL(100024, "验证码校验失败"), 
	/**
	 * 商品不存在或已下架
	 * */
	PRODUCT_NOT_EXIST(100025,"商品不存在或已下架"),
	/**
	 * 订单不存在
	 * */
	ORDER_NOT_EXIST(100026,"订单不存在"), 
	/**
	 * 未知的商品类型
	 * */
	UNKNOWN_PRODUCT_TYPE(100027,"未知的商品类型"), 
	/**
	 * 订单已处理过
	 * */
	ORDER_REPEAT(100028,"重复订单"),
	/**
	 * 手机号没有注册
	 */
	PHONE_NOT_REGISTER(100029, "手机号没有注册"), 
	/**
	 * 帐号未登陆
	 * */
	ACCOUNT_NOT_LOGIN(100030,"帐号未登陆"), 
	/**
	 * 成员不存在
	 * */
	USER_NOT_EXIST(100031,"成员不存在"), 
	/**
	 * 帐号没有这个成员
	 * */
	USER_NOT_IN_ACCOUNT(100032,"帐号没有这个成员"), 
	/**
	 * 不需要重复购买
	 * */
	PLAN_REPEAT_BUY(100033,"不需要重复购买"), 
	/**
	 * 用户栗子不足
	 * */
	USER_GOLD_NOT_ENOUGH(100034,"用户栗子不足"),
	/**
	 * 成员已被绑定到其他账号
	 */
	USER_BELONG_OTHER_ACCOUNT(100033,"成员已被绑定到其他账号"), 
	/**
	 * 消息不存在
	 * 
	 * */
	MESSAGE_NOT_EXIST(100034,"消息不存在"), 
	/**
	 * 消息类型错误
	 * */
	MESSAGE_TYPE_ERROR(100035,"消息类型错误"), 
	/**
	 * 任务不存在
	 * */
	TASK_NOT_EXIST(100036,"任务不存在"), 
	/**
	 * 任务状态异常
	 * */
	TASK_STATUS_ERROR(100037,"任务状态异常"), 
	/**
	 * 不可重复领取
	 * */
	MESSAGE_REPEAT_RECEIVED_GOLD(100038,"不可重复领取"), 
	/**
	 * 至少保留一个成员
	 * */
	ACCOUNT_CAN_NOT_LESS_ONE_MEMBER(100039,"帐号至少需要有一个成员"), 
	/**
	 * 用户名称已存在
	 * */
	USER_NAME_EXIST(100040,"昵称已被使用已存在"), 
	/**
	 * imei为空
	 * */
	IMEI_IS_BLANK(100041,"游客登陆失败,缺少imei"), 
	/**
	 * 食物不存在
	 * */
	FOOD_NOT_EXIST(100042,"食物不存在"), FOOD_NUM_NOT_ENGHOU(100043,"食物数量不足"), NOT_FOOD(100043,"只能喂食物"), 
	/**
	 * 今日次数已达上限
	 * */
	FEED_FOOD_TODAY_IS_FULL(100044,"请明日再来喂食"), 
	/**
	 * 家庭组密码验证失败
	 * */
	PARENT_TOKEN_ERROR(100045,"家庭组密码验证失败");

	public int code;
	public String msg;

	private APIExceptionCode(int code, String msg) {
		this.msg = msg;
		this.code = code;
	}
}
