package com.iquizoo.manage.web.product.dto;

import com.iquizoo.manage.web.product.po.Prop;

/**
 * 道具
 * @author Jianxing Wen
 * @date 2016-8-26下午3:28:05
 */
public class PropDto extends Prop{

	public static final String 	TYPE_FOOD="食物",TYPE_CARD="卡片";
	public static final String 	RANDOM_FALSE="是",RANDOM_TRUE="否";
	public static final String 	SUB_TYPE_GOLD="栗子",SUB_TYPE_OTHER="其他";
	
	private String typeName;// 类型名
	private String randomName;// 是否随机
	private String subName;// 具体类型
	
	
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getRandomName() {
		return randomName;
	}
	public void setRandomName(String randomName) {
		this.randomName = randomName;
	}
	@Override
	public String toString() {
		return "PropDto["+"typeName="+typeName+",randomName="+randomName+"]";
	}
}
