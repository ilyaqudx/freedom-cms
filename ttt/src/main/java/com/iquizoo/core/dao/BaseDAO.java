package com.iquizoo.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.iquizoo.core.page.Page;

public class BaseDAO extends SqlMapClientDaoSupport
{

	@Resource(name = "sqlMapClient")
	public SqlMapClient sqlMapClient;

	@PostConstruct
	public void initSqlMapClient()
	{
		super.setSqlMapClient(sqlMapClient);
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
		Integer count = (Integer) sqlMapClient.queryForObject(sqlId+"Count", params);
		params.put("page", page);
		//得到数据
		List data = sqlMapClient.queryForList(sqlId, params);
		page.setCount(count);
		page.setData(data);
		return page;
	}
}
