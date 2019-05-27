package com.crm.entity;

import org.springframework.stereotype.Component;

@Component
public class Mokuai {
private Integer mkid;
private String mkname;
private String  mkwangzhi;
private String  mkzhixiang;

private Integer mkjiedian;
private Integer jeid;


public Integer getMkjiedian() {
	return mkjiedian;
}
public void setMkjiedian(Integer mkjiedian) {
	this.mkjiedian = mkjiedian;
}
public Integer getJeid() {
	return jeid;
}
public void setJeid(Integer jeid) {
	this.jeid = jeid;
}
public Integer getMkid() {
	return mkid;
}
public void setMkid(Integer mkid) {
	this.mkid = mkid;
}
public String getMkname() {
	return mkname;
}
public void setMkname(String mkname) {
	this.mkname = mkname;
}

public String getMkwangzhi() {
	return mkwangzhi;
}
public void setMkwangzhi(String mkwangzhi) {
	this.mkwangzhi = mkwangzhi;
}
public String getMkzhixiang() {
	return mkzhixiang;
}
public void setMkzhixiang(String mkzhixiang) {
	this.mkzhixiang = mkzhixiang;
}
@Override
public String toString() {
	return "Mokuai [mkid=" + mkid + ", mkname=" + mkname + ", mkwangzhi=" + mkwangzhi + ", mkzhixiang=" + mkzhixiang
			+ ", mkjiedian=" + mkjiedian + ", jeid=" + jeid + "]";
}


}
