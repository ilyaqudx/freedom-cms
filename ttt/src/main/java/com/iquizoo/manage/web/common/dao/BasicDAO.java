package com.iquizoo.manage.web.common.dao;

import java.util.List;

public interface BasicDAO<T> {

    public int insert(T t)throws Exception;
	
	public void delete(int id)throws Exception;
	
	public void update(T t)throws Exception;
	
	public T getById(int id)throws Exception;
	
	public List<T> getList() throws Exception;

}
