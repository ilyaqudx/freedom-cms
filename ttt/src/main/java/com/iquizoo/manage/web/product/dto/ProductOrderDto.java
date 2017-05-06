package com.iquizoo.manage.web.product.dto;

import com.iquizoo.manage.web.product.po.ProductOrder;

/**
 * 商品订单dto
 * 
 * @author Jianxing Wen
 * @date 2016-7-6下午1:51:55
 */
public class ProductOrderDto extends ProductOrder {
	
	/**
	 * 订单状态
	 * 0-处理中
	 * 1-成功 
	 * 2-失败
	 * */
	public static final String  STATUS_PROCESSING = "处理中",STATUS_SUCCESS = "成功",STATUS_FAILED = "失败";
	/**
	 * 客户端类型
	 * 31-安卓
	 * 32-IOS
	 */
	public static final String CLIENT_ANDROID = "安卓",CLIENT_IOS = "IOS";

	/**
	 * 支付类型
	 * 1-支付宝
	 * 2-IOS
	 */
	public static final String PAYTYPE_ALI = "支付宝",PAYTYPE_APPLE = "IOS";
	
	private String userName;// 用户名
	private String productName;// 商品名
	private String statusName;// 状态名
	private String clientName;// 客户端类型名
	private String payTypeName;// 支付类型名
	private String phone;// 电话

	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPayTypeName() {
		return payTypeName;
	}

	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}

	@Override
	public String toString() {
		return "ProductOrderDto[" + "productName=" + productName
				+ "statusName=" + statusName + "clientName=" + clientName
				+ "payTypeName=" + payTypeName + "]";
	}

}
