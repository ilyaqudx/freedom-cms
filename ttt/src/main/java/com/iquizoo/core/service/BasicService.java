package com.iquizoo.core.service;

import java.util.List;

public interface BasicService<T> {

	public int insert(T t) throws Exception;

	public void delete(int id) throws Exception;

	public void update(T t) throws Exception;

	public T get(int id) throws Exception;
	
	public List<T> list()throws Exception;
}
