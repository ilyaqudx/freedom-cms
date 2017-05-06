package com.iquizoo.manage.base.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 数结构
 * @author GouZhongLiang
 * @date 2015-9-6 下午6:44:32
 */
public class Tree {
	/**ID*/
	private Integer id;
	private String text;
	private Integer value;
	private Integer type = 0;
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	private Boolean showcheck = true;
	private Boolean complete = true;
	private Boolean isexpand = true;
	private Integer checkstate = 0;
	private Boolean hasChildren = false;
	private Tree parentNode;
	private List<Tree> childNodes = new ArrayList<Tree>();
	
	public Tree(){}
	
	public Tree(Integer id, String text, Integer value, Boolean showcheck,
			Boolean complete, Boolean isexpand, Integer checkstate, Boolean hasChildren){
		this.id = id;
		this.text = text;
		this.value = value;
		this.showcheck = showcheck;
		this.complete = complete;
		this.isexpand = isexpand;
		this.checkstate = checkstate;
		this.hasChildren = hasChildren;
	}
	
	/**
	 * 创建根节点
	 * @param name
	 * @return
	 * @author GouZhongLiang
	 * @date 2015-9-7 上午10:04:33
	 */
	public static Tree createRootTree(String name){
		Tree tree = new Tree(0,name,0,true,true,true,0,true);
		return tree;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Boolean getShowcheck() {
		return showcheck;
	}
	public void setShowcheck(Boolean showcheck) {
		this.showcheck = showcheck;
	}
	public Boolean getComplete() {
		return complete;
	}
	public void setComplete(Boolean complete) {
		this.complete = complete;
	}
	public Boolean getIsexpand() {
		return isexpand;
	}
	public void setIsexpand(Boolean isexpand) {
		this.isexpand = isexpand;
	}
	public Integer getCheckstate() {
		return checkstate;
	}
	public void setCheckstate(Integer checkstate) {
		this.checkstate = checkstate;
	}
	public Boolean getHasChildren() {
		return hasChildren;
	}
	public void setHasChildren(Boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
	public List<Tree> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(List<Tree> childNodes) {
		childNodes = childNodes;
	}
	public Tree getParentNode() {
		return parentNode;
	}

	public void setParentNode(Tree parentNode) {
		this.parentNode = parentNode;
	}

	/**
	 * 添加子节点
	 * @param tree
	 * @author GouZhongLiang
	 * @date 2015-9-7 上午9:43:33
	 */
	public void addChildNode(Tree tree){
		this.childNodes.add(tree);
	}
}
