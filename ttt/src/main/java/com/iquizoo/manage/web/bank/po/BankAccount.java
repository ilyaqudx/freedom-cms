package com.iquizoo.manage.web.bank.po;

public class BankAccount {

	private Integer id;
	private Integer userId;
	private Integer bankId;//银行ID
	private String  bankName;//银行名称
	private String  account;//银行帐号
	private String  accountName;//开户人名称
	private String  bankBranch;//开户行支行
	private String  bankAddress;//开户行地址
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
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
	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", userId=" + userId + ", bankId=" + bankId + ", bankName=" + bankName
				+ ", account=" + account + ", accountName=" + accountName + ", bankBranch=" + bankBranch
				+ ", bankAddress=" + bankAddress + "]";
	}
}
