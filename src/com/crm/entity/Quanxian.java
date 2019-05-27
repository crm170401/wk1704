package com.crm.entity;

import org.springframework.stereotype.Component;

@Component
public class Quanxian {
	private Integer qxid;
	private Integer qxuserid;
	private Integer qxsuoding;
	private Integer qxinsert;
	private Integer qxdelete;
	private Integer qxupdate;
	private Integer qxselect;
	public Integer getQxid() {
		return qxid;
	}
	public void setQxid(Integer qxid) {
		this.qxid = qxid;
	}
	public Integer getQxuserid() {
		return qxuserid;
	}
	public void setQxuserid(Integer qxuserid) {
		this.qxuserid = qxuserid;
	}
	public Integer getQxsuoding() {
		return qxsuoding;
	}
	public void setQxsuoding(Integer qxsuoding) {
		this.qxsuoding = qxsuoding;
	}
	public Integer getQxinsert() {
		return qxinsert;
	}
	public void setQxinsert(Integer qxinsert) {
		this.qxinsert = qxinsert;
	}
	public Integer getQxdelete() {
		return qxdelete;
	}
	public void setQxdelete(Integer qxdelete) {
		this.qxdelete = qxdelete;
	}
	public Integer getQxupdate() {
		return qxupdate;
	}
	public void setQxupdate(Integer qxupdate) {
		this.qxupdate = qxupdate;
	}
	public Integer getQxselect() {
		return qxselect;
	}
	public void setQxselect(Integer qxselect) {
		this.qxselect = qxselect;
	}
	@Override
	public String toString() {
		return "Quanxian [qxid=" + qxid + ", qxuserid=" + qxuserid + ", qxsuoding=" + qxsuoding + ", qxinsert="
				+ qxinsert + ", qxdelete=" + qxdelete + ", qxupdate=" + qxupdate + ", qxselect=" + qxselect + "]";
	}
	
}
