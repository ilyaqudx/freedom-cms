package freedom.cms.domain;

import java.util.Date;

/**  
 * 创建时间: 2017年5月3日 下午12:24:27  
 * 项目名称: freedom-cms  
 * @author freedom  
 * @version 1.0   
 * @since JDK 1.8.0_21  
 * 文件名称: User.java  
 * 类说明:  
 */
public class User {

	private Long id;
	private String code;//编号,唯一
	private String name;//姓名
	private String loginPassword;//一级密码,登陆密码
	private String payPassword;//二级密码
	private String phone;//手机
	private String identityCode;//身份证
	private Integer    sex;//性别
	private String address;//家庭地址
	private Date   createTime;//创建时间
	private Date   activationTime;//激活日期
	private Integer    status;//状态
	private String recommender;//推荐人编号
	private String settler;//安置人编号
	private String marketLocation;//市场位置
	
	private String bank;//银行名称
	private String bankAccount;//银行帐号
	private String bankAccountName;//开户人
	private String bankAddress;//开户银行地址
	private String province;//省
	private String city;//市
	private String area;//区
	private String receivingAddress;//收货地址
	private Integer admin;
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	public Date getActivationTime() {
		return activationTime;
	}
	public void setActivationTime(Date activationTime) {
		this.activationTime = activationTime;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRecommender() {
		return recommender;
	}
	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}
	public String getSettler() {
		return settler;
	}
	public void setSettler(String settler) {
		this.settler = settler;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getBankAccountName() {
		return bankAccountName;
	}
	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getReceivingAddress() {
		return receivingAddress;
	}
	public void setReceivingAddress(String receivingAddress) {
		this.receivingAddress = receivingAddress;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getPayPassword() {
		return payPassword;
	}
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	public String getMarketLocation() {
		return marketLocation;
	}
	public void setMarketLocation(String marketLocation) {
		this.marketLocation = marketLocation;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", code=" + code + ", name=" + name + ", loginPassword=" + loginPassword
				+ ", payPassword=" + payPassword + ", phone=" + phone + ", identityCode=" + identityCode + ", sex="
				+ sex + ", address=" + address + ", createTime=" + createTime + ", status=" + status + ", recommender="
				+ recommender + ", settler=" + settler + ", marketLocation=" + marketLocation + ", bank=" + bank
				+ ", bankAccount=" + bankAccount + ", bankAccountName=" + bankAccountName + ", bankAddress="
				+ bankAddress + ", province=" + province + ", city=" + city + ", area=" + area + ", receivingAddress="
				+ receivingAddress + "]";
	}
	
}
