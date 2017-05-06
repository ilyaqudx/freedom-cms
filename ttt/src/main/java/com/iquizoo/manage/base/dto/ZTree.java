package com.iquizoo.manage.base.dto;

/**
 * @Description ZTree数据对象
 * @author GouZhongLiang
 * @date 2016-7-13 上午11:01:33
 */
public class ZTree {

	private int id;//Id
	
	private int pId;//父节点id
	
	private String name;//显示名称
	
	private boolean open;//是否打开
	
	private boolean isParent;//是否为父节点

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPId() {
		return pId;
	}

	public void setPId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}
	
}
