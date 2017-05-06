package com.iquizoo.core.page;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * @Description 分页类
 * @author GouZhongLiang
 * @date 2015-7-17 上午11:26:01
 */
public class Page {
	/**数据*/
	private List data;
	/**总条数*/
	private int count;
	/**总页数*/
	private int totalPage;
	/**第一页*/
	private int firstPage = 1;
	/**尾页*/
	private int endPage;
	/**每页数据量*/
	private int pageSize = 10;
	/**当前页*/
	private int currentPage = 1;
	/**第一条数据*/
	private int firstItem = 0;
	/**显示的开始页*/
	private int showPageStart;
	/**显示的结束页*/
	private int showPageEnd;
	
	public Page(){}
	
	public Page(Integer currentPage, Integer pageSize){
		if(currentPage != null){
			setCurrentPage(currentPage);
		}
		if(pageSize != null){
			setPageSize(pageSize);
		}
	}
	
	public int getShowPageStart() {
		int start = 0;
		if(getCurrentPage() <= 5){
			start =1;
		}else{
			start = getCurrentPage()-5;
		}
		return start;
	}
	public void setShowPageStart(int showPageStart) {
		this.showPageStart = showPageStart;
	}
	public int getShowPageEnd() {
		int end = 0;
		int total = getTotalPage();
		if(total <= 10 || getCurrentPage() + 5 >= total){
			end = total;
		}else{
			end = getCurrentPage() + 5;
		}
		return end;
	}
	public void setShowPageEnd(int showPageEnd) {
		this.showPageEnd = showPageEnd;
	}

	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPage() {
		if((count % pageSize) > 0){
			return count/pageSize + 1;
		}else{
			return count/pageSize;
		}
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getEndPage() {
		return getTotalPage();
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "Pager [data=" + data + "]";
	}
	public int getFirstItem() {
		return (getCurrentPage()-1) * getPageSize();
	}
	public void setFirstItem(int firstItem) {
		this.firstItem = firstItem;
	}

	public String json() {
		return JSON.toJSONString(this);
	}
}
