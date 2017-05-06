package com.iquizoo.manage.base.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.iquizoo.core.page.DataTable;

public class BaseAzyDAO extends SqlSessionDaoSupport{

	@Resource(name = "sqlSessionFactory2")
	public SqlSessionFactory sqlSessionFactory;
	
	@PostConstruct
	public void initSqlMapClient()
	{
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public DataTable queryTable(DataTable table, String sqlId) {
		table.getParams().put("start", table.getStart());
		table.getParams().put("length", table.getLength());
		int orderIndex = table.getOrder().getJSONObject(0).getIntValue("column");
		String dir = table.getOrder().getJSONObject(0).getString("dir");
		String columnName = table.getColumns().getJSONObject(orderIndex).getString("data");
		//排序
		table.getParams().put("order", new StringBuilder().append(columnName).append(" ").append(dir).toString());
		//总数量
		Integer total = (Integer) getSqlSession().selectOne(sqlId+"Count", table.getParams());
		table.setRecordsTotal(total);
		//得到数量
		Integer count = (Integer) getSqlSession().selectOne(sqlId+"Count", table.getParams());
		table.setRecordsFiltered(count);
		//得到数据
		List data = getSqlSession().selectList(sqlId, table.getParams());
		table.setData(data);
		return table;
	}
}
