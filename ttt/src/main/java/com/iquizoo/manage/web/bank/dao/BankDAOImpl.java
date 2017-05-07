package com.iquizoo.manage.web.bank.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iquizoo.core.dao.mybatis.BaseDAO;
import com.iquizoo.manage.web.bank.po.Bank;
@Repository
public class BankDAOImpl extends BaseDAO implements BankDAO{

	@Override
	public List<Bank> getBankList() {
		return getSqlSession().selectList("getBankList");
	}

	@Override
	public Bank getBankById(Integer id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("getBankById", id);
	}

}
