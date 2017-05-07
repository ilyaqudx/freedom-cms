package com.iquizoo.manage.web.bank.vo;

import com.iquizoo.manage.web.admin.po.Admin;

public class AdminVO extends Admin {

	private String account;
	private String accountName;
	private Integer bankId;
	private String bankName;
	private String bankBranch;
	private String bankAddress;
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
}
