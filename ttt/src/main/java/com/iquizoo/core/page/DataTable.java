package com.iquizoo.core.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 * @Description 
 * @author GouZhongLiang
 * @date 2016-6-15 下午3:05:27
 */
public class DataTable<T> {

	//当前页
	private int draw = 1;
	//总的记录数
	private int recordsTotal;
	//过滤后的记录数
	private int recordsFiltered;
	//数据
	private List<T> data = new ArrayList<T>();
	
	//起始数据
	private int start;
	//数据条数
	private int length;
	//列
	private JSONArray columns;
	//排序
	private JSONArray order;
	//参数
	private Map<String,Object> params = new HashMap<String,Object>();
	
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = JSON.parseObject(params, Map.class);
	}
	public JSONArray getColumns() {
		return columns;
	}
	public void setColumns(String columns) {
		this.columns = JSON.parseArray(columns);
	}
	public JSONArray getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = JSON.parseArray(order);
	}
	
	public void addParam(String key, String value){
		this.params.put(key, value);
	}
}
