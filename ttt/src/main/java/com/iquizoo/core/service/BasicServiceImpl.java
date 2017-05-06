package com.iquizoo.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iquizoo.core.dao.BasicDAO;

public abstract class BasicServiceImpl<T> implements BasicService<T> {

	@Autowired
	private BasicDAO<T> basicDAO;
	
	@Override
	public int insert(T t) throws Exception {
		// TODO Auto-generated method stub
		return basicDAO.insert(t);
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		basicDAO.delete(id);
	}

	@Override
	public void update(T t) throws Exception {
		// TODO Auto-generated method stub
		basicDAO.update(t);
	}

	@Override
	public T get(int id) throws Exception {
		// TODO Auto-generated method stub
		return basicDAO.get(id);
	}

	@Override
	public List<T> list() throws Exception {
		// TODO Auto-generated method stub
		return basicDAO.list();
	}

	
}
