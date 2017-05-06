package com.iquizoo.manage.web.common.service;

import java.util.List;

/**
 * 
 * @author Jianxing Wen
 * @date 2016-7-22下午5:21:37
 * @param <T>
 */
public interface BasicAZYService<T> {

	public int insert(T t) throws Exception;

	public void delete(int id) throws Exception;

	public void update(T t) throws Exception;

	public T getById(int id) throws Exception;
	
	public List<T> getList() throws Exception;
	
}
