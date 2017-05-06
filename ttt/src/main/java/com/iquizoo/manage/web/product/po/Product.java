package com.iquizoo.manage.web.product.po;

/**
 * 商品
 * */
public class Product {

	/**
	 * 产品类型
	 * 1-VIP
	 * 2-金币
	 * 3-计划
	 * */
	public static final int TYPE_VIP = 1,TYPE_GOLD = 2 , TYPE_PLAN = 3;
	/**
	 * 支付方式
	 * 1-支付宝
	 * 2-ios
	 * */
	public static final int PAY_TYPE_ALIPAY = 1,PAY_TYPE_APPLE_PAY = 2;
	//仅仅作为商品的序号，没有任务业务逻辑
	private int id;
	//类型
	private int type;
	//商品标识码(区分同一类商品下多个不同子项用)
	private int code;
	private String name;
	//原价
	private float originalPrice;
	//普通价格
	private float price;
	//ios原价
	private float iosOriginalPrice;
	//ios价格
	private float iosPrice;
	//购买成功后,获得的商品数量(VIP-会员天数,金币-数量)
	private int count;
	//支付代码(ios需要)
	private String payCode;
	//上架,下架
	private int status;
	private String description;
	public float getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(float originalPrice) {
		this.originalPrice = originalPrice;
	}
	public float getIosOriginalPrice() {
		return iosOriginalPrice;
	}
	public void setIosOriginalPrice(float iosOriginalPrice) {
		this.iosOriginalPrice = iosOriginalPrice;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getIosPrice() {
		return iosPrice;
	}
	public void setIosPrice(float iosPrice) {
		this.iosPrice = iosPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPayCode() {
		return payCode;
	}
	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
