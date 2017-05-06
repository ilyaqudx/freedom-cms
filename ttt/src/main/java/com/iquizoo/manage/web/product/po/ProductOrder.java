package com.iquizoo.manage.web.product.po;

import java.util.Date;

/**商品订单
 * @author m00056
 *
 */
public class ProductOrder {

	/**
	 * 订单状态
	 * 0-处理中
	 * 1-成功 
	 * 2-失败
	 * */
	public static final int STATUS_PROCESSING = 0,STATUS_SUCCESS = 1,STATUS_FAILED = 2;
	/**
	 * 客户端类型
	 * 31-安卓
	 * 32-IOS
	 */
	public static final int CLIENT_ANDROID = 31,CLIENT_IOS = 32;

	/**
	 * 支付类型
	 * 1-支付宝
	 * 2-IOS
	 */
	public static final int PAYTYPE_ALI = 1,PAYTYPE_APPLE = 2;
	
	private int id;
	//订单号
	private String orderNo;
	//用户id
	private int userId;
	//帐号id
	private int accountId;
	//产品id
	private int productId;
	//产品数量
	private int num;
	//订单金额
	private float amount;
	//订单状态
	private int status;
	//客户端类型(31-android,32-ios)
	private int client;
	//支付方式(1-ali,2-apple)
	private int payType;
	//创建时间
	private Date createTime;
	//订单处理时间
	private Date updateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getClient() {
		return client;
	}
	public void setClient(int client) {
		this.client = client;
	}
	public int getPayType() {
		return payType;
	}
	public void setPayType(int payType) {
		this.payType = payType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "ProductOrder [id=" + id + ", orderNo=" + orderNo + ", userId="
				+ userId + ", accountId=" + accountId + ", productId="
				+ productId + ", num=" + num + ", amount=" + amount
				+ ", status=" + status + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
}
