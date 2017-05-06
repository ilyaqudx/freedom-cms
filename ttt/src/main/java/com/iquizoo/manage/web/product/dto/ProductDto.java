package com.iquizoo.manage.web.product.dto;

import com.iquizoo.manage.web.product.po.Product;

/**
 * 产品
 * @author Jianxing Wen
 * @date 2016-7-5上午10:58:36
 */
public class ProductDto extends Product{


	 /** 类型名称 VIP 和 栗子*/
	private String typeName;
	/** 状态 正常 和 下架*/
	private String statusName;
	/** 产品标识 VIP,高级VIP，钻石VIP*/
	private String codeName;
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	
	@Override
	public String toString(){
		return "ProductDto["+"typeName="+typeName+"statusName="+statusName+"codeName="+codeName+"]";
	}
}
