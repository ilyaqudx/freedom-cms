package com.iquizoo.core.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class BasicDAOImpl<T> extends BaseDAO implements BasicDAO<T> {

	private Class<T> entity;
	private String simpleName;
	
	@SuppressWarnings("unchecked")
	public BasicDAOImpl()
	{
		Type[] types = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
		entity = (Class<T>) types[0];
		simpleName = entity.getSimpleName();
	}
	
	@Override
	public int insert(T t) throws Exception 
	{
		Object obj = sqlMapClient.insert(simpleName + ".insert", t);
		return null == obj ? 0 : (Integer)obj;
	}

	@Override
	public void delete(int id) throws Exception 
	{
		sqlMapClient.delete(simpleName + ".delete", id);
	}

	@Override
	public void update(T t) throws Exception 
	{
		sqlMapClient.update(simpleName + ".update", t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int id) throws Exception 
	{
		return (T) sqlMapClient.queryForObject(simpleName + ".get", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() throws Exception
	{
		return sqlMapClient.queryForList(simpleName + ".list");
	}

	
}
