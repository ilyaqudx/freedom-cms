package freedom.cms.domain;

import java.util.Date;

public class CashOrder {

	public static final int STATUS_PROCESSING = 0,STATUS_FORBIDDEN = 1,STATUS_SUCCESS = 2;
	private Long id;
	private String orderNo;
	private Long userId;
	private Float amount;
	private Float actualAmount;
	private Integer status;
	private Integer operator;
	private String  remark;
	private Date createTime;
	private Date updateTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Float getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(Float actualAmount) {
		this.actualAmount = actualAmount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getOperator() {
		return operator;
	}
	public void setOperator(Integer operator) {
		this.operator = operator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "CashOrder [orderNo=" + orderNo + ", userId=" + userId + ", amount=" + amount + ", actualAmount="
				+ actualAmount + ", status=" + status + ", operator=" + operator + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
}
