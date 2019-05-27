package com.crm.entity;

import org.springframework.stereotype.Component;

@Component
public class juetea {
	 private Integer jmid;
	 private Integer jeid;
	 private Integer tid;
	public Integer getJmid() {
		return jmid;
	}
	public void setJmid(Integer jmid) {
		this.jmid = jmid;
	}
	public Integer getJeid() {
		return jeid;
	}
	public void setJeid(Integer jeid) {
		this.jeid = jeid;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "juetea [jmid=" + jmid + ", jeid=" + jeid + ", tid=" + tid + "]";
	}
	 
}
