package com.iquizoo.manage.web.vip.po;

import java.util.Date;

public class AccountVip {

    private int id;
    private int accountId;
    private int userId;
    private int vipId;
    private int status;
    private Date createTime;
    private Date startTime;
    private Date EndTime;
    private String mark;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getVipId() {
        return vipId;
    }

    public void setVipId(int vipId) {
        this.vipId = vipId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    @Override
    public String toString() {
        return "UserVip [id=" + id + ", accountId=" + accountId + ", userId="
                + userId + ", status=" + status + ", createTime=" + createTime
                + ", startTime=" + startTime + ", EndTime=" + EndTime + "]";
    }

}
