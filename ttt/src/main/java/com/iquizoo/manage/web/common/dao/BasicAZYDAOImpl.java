package com.iquizoo.manage.web.common.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.iquizoo.manage.base.dao.BaseAzyDAO;

public class BasicAZYDAOImpl<T> extends BaseAzyDAO implements BasicAZYDAO<T>{

	private Class<T> entity;
	private String simpleName;
	
	@SuppressWarnings("unchecked")
	public BasicAZYDAOImpl()
	{
		Type[] types = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
		entity = (Class<T>) types[0];
		simpleName = entity.getSimpleName();
	}
	
	@Override
	public int insert(T t) throws Exception {
		Object obj = getSqlSession().insert(simpleName + ".insert", t);
		return obj == null ? 0 : (Integer)obj;
	}

	@Override
	public void delete(int id) throws Exception {
		getSqlSession().delete(simpleName + ".delete", id);
	}

	@Override
	public void update(T t) throws Exception {
		getSqlSession().update(simpleName + ".update", t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(int id) throws Exception {
		 
		return (T) getSqlSession().selectOne(simpleName + ".getById", id);
	}

	@Override
	public List<T> getList() throws Exception {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(simpleName + ".list");
	}

}
