package com.iquizoo.manage.web.product.po;

/**
 * 道具
 * */
public class Prop {

	/**
	 * 1-食物(此类看是否需要再细分)
	 * 2-宠物卡片
	 * */
	public static final int TYPE_FOOD = 1,TYPE_PET_CARD = 2;
	/**
	 * 21-栗子(栗子也可以喂食,不过还有其他的用途)
	 * */
	public static final int SUB_TYPE_GOLD = 11;
	
	private int id;
	//大类(食物)
	private int type;
	//具体物品(栗子)
	private int subType;
	private String name;
	private String image;
	private String description;
	//如果类型是卡片(是否可以随机获取)
	private int random;
	//使用后增加宠物经验值
	private int petExp;
	
	
	public int getPetExp() {
		return petExp;
	}
	public void setPetExp(int petExp) {
		this.petExp = petExp;
	}
	public int getRandom() {
		return random;
	}
	public void setRandom(int random) {
		this.random = random;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public int getSubType() {
		return subType;
	}
	public void setSubType(int subType) {
		this.subType = subType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Prop [id=" + id + ", type=" + type + ", name=" + name
				+ ", description=" + description + "]";
	}
}
