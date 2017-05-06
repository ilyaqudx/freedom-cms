package com.iquizoo.core.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.core.page.Page;


public class BaseDAO extends SqlSessionDaoSupport{

	@Resource(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory;

	@PostConstruct
	public void initSqlMapClient()
	{
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	/**
	 * 分页查询
	 * @param params
	 * @param page
	 * @param sqlId
	 * @return
	 * @throws Exception
	 * @author GouZhongLiang
	 * @date 2016-6-14 上午10:18:50
	 */
	public Page queryPage(Map<String,Object> params, Page page, String sqlId) throws Exception{
		if(params == null){
			params = new HashMap<String,Object>();
		}
		Set<String> keys = params.keySet();
		for(String key : keys){
			Object obj = params.get(key);
			if(obj instanceof Page){
				params.remove(key);
			}
		}
		//得到数量
		Integer count = (Integer) getSqlSession().selectOne(sqlId+"Count", params);
		params.put("page", page);
		//得到数据
		List data = getSqlSession().selectList(sqlId, params);
		page.setCount(count);
		page.setData(data);
		return page;
	}
	
	public DataTable queryTable(DataTable table, String sqlId) {
 		table.getParams().put("start", table.getStart());
		table.getParams().put("length", table.getLength());
		int orderIndex = table.getOrder().getJSONObject(0).getIntValue("column");
		String dir = table.getOrder().getJSONObject(0).getString("dir");
		String columnName = table.getColumns().getJSONObject(orderIndex).getString("data");

		// 排序
		table.getParams().put("order", new StringBuilder().append(columnName).append(" ").append(dir).toString());

		// 总数量
		Integer total = (Integer) getSqlSession().selectOne(sqlId+"Count");
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
