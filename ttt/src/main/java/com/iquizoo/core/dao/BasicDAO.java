package com.iquizoo.core.dao;

import java.util.List;

public interface BasicDAO<T> {

	public int insert(T t)throws Exception;
	
	public void delete(int id)throws Exception;
	
	public void update(T t)throws Exception;
	
	public T get(int id)throws Exception;

	public List<T> list()throws Exception;
}
