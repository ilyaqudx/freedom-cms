package com.iquizoo.manage.web.common.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.iquizoo.core.dao.mybatis.BaseDAO;

public class BasicDAOImpl<T> extends BaseDAO implements BasicDAO<T> {

	private Class<T> entry;
	private String simpleName;
	
	@SuppressWarnings("unchecked")
	public BasicDAOImpl(){
		Type[] types = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
		entry = (Class<T>)types[0];
		simpleName = entry.getSimpleName();
	}
	@Override
	public int insert(T t) throws Exception {
		return getSqlSession().insert(simpleName +".insert", t);
	}

	@Override
	public void delete(int id) throws Exception {

		getSqlSession().delete(simpleName + ".delete", id);
	}

	@Override
	public void update(T t) throws Exception {

		getSqlSession().update(simpleName + ".update", t);
	}

	@Override
	public T getById(int id) throws Exception {
		return getSqlSession().selectOne(simpleName + ".getById", id);
	}

	@Override
	public List<T> getList() throws Exception {
		return getSqlSession().selectList(simpleName + ".getList");
	}

}
