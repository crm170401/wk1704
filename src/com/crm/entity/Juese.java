package com.crm.entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Juese {
private Integer jeid;
private String jename;
private String jeby1;
private String jeby2;
private String jeinsert;
private String jeupdate;
private String jedelete;

private Integer jemkid;

private List<Mokuai> mokuai;


public Integer getJemkid() {
	return jemkid;
}
public void setJemkid(Integer jemkid) {
	this.jemkid = jemkid;
}
public List<Mokuai> getMokuai() {
	return mokuai;
}
public void setMokuai(List<Mokuai> mokuai) {
	this.mokuai = mokuai;
}
public Integer getJeid() {
	return jeid;
}
public void setJeid(Integer jeid) {
	this.jeid = jeid;
}
public String getJename() {
	return jename;
}
public void setJename(String jename) {
	this.jename = jename;
}
public String getJeby1() {
	return jeby1;
}
public void setJeby1(String jeby1) {
	this.jeby1 = jeby1;
}
public String getJeby2() {
	return jeby2;
}
public void setJeby2(String jeby2) {
	this.jeby2 = jeby2;
}
public String getJeinsert() {
	return jeinsert;
}
public void setJeinsert(String jeinsert) {
	this.jeinsert = jeinsert;
}
public String getJeupdate() {
	return jeupdate;
}
public void setJeupdate(String jeupdate) {
	this.jeupdate = jeupdate;
}
public String getJedelete() {
	return jedelete;
}
public void setJedelete(String jedelete) {
	this.jedelete = jedelete;
}
@Override
public String toString() {
	return "Juese [jeid=" + jeid + ", jename=" + jename + ", jeby1=" + jeby1 + ", jeby2=" + jeby2 + ", jeinsert="
			+ jeinsert + ", jeupdate=" + jeupdate + ", jedelete=" + jedelete + ", jemkid=" + jemkid + ", mokuai="
			+ mokuai + "]";
}

}
