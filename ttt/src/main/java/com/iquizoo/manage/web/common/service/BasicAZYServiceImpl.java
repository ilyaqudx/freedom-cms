package com.iquizoo.manage.web.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iquizoo.manage.web.common.dao.BasicAZYDAO;

/**
 * 基本
 * @author Jianxing Wen
 * @date 2016-7-22下午5:25:01
 * @param <T>
 */
public class BasicAZYServiceImpl<T> implements BasicAZYService<T>{

	@Autowired
	private BasicAZYDAO<T> basicDAO;
	@Override
	public int insert(T t) throws Exception {
		return basicDAO.insert(t);
	}

	@Override
	public void delete(int id) throws Exception {
		basicDAO.delete(id);
	}

	@Override
	public void update(T t) throws Exception {
		basicDAO.update(t);
	}

	@Override
	public T getById(int id) throws Exception {
		return basicDAO.getById(id);
	}


	@Override
	public List<T> getList() throws Exception {
		return basicDAO.getList();
	}

}
