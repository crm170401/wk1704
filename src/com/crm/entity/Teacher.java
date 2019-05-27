package com.crm.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Teacher {
private Integer teacherid;
private String teachname;
private String teachzhuangtai;
private String teachquanzhong;
private String teachpassword;
private String teachphone;
private String teachqiandaoshijian;
private Integer teachqiandaocishu;
private Integer qxsuoding;
private String jename;

private List<Juese> juese;

public List<Juese> getJuese() {
	return juese;
}
public void setJuese(List<Juese> juese) {
	this.juese = juese;
}
public String getJename() {
	return jename;
}
public void setJename(String jename) {
	this.jename = jename;
}
public Integer getTeacherid() {
	return teacherid;
}
public void setTeacherid(Integer teacherid) {
	this.teacherid = teacherid;
}
public String getTeachname() {
	return teachname;
}
public void setTeachname(String teachname) {
	this.teachname = teachname;
}
public String getTeachzhuangtai() {
	return teachzhuangtai;
}
public void setTeachzhuangtai(String teachzhuangtai) {
	this.teachzhuangtai = teachzhuangtai;
}
public String getTeachquanzhong() {
	return teachquanzhong;
}
public void setTeachquanzhong(String teachquanzhong) {
	this.teachquanzhong = teachquanzhong;
}
public String getTeachpassword() {
	return teachpassword;
}
public void setTeachpassword(String teachpassword) {
	this.teachpassword = teachpassword;
}
public String getTeachphone() {
	return teachphone;
}
public void setTeachphone(String teachphone) {
	this.teachphone = teachphone;
}
public String getTeachqiandaoshijian() {
	return teachqiandaoshijian;
}
public void setTeachqiandaoshijian(String teachqiandaoshijian) {
	this.teachqiandaoshijian = teachqiandaoshijian;
}
public Integer getTeachqiandaocishu() {
	return teachqiandaocishu;
}
public void setTeachqiandaocishu(Integer teachqiandaocishu) {
	this.teachqiandaocishu = teachqiandaocishu;
}

public Integer getQxsuoding() {
	return qxsuoding;
}
public void setQxsuoding(Integer qxsuoding) {
	this.qxsuoding = qxsuoding;
}
@Override
public String toString() {
	return "Teacher [teacherid=" + teacherid + ", teachname=" + teachname + ", teachzhuangtai=" + teachzhuangtai
			+ ", teachquanzhong=" + teachquanzhong + ", teachpassword=" + teachpassword + ", teachphone=" + teachphone
			+ ", teachqiandaoshijian=" + teachqiandaoshijian + ", teachqiandaocishu=" + teachqiandaocishu
			+ ", qxsuoding=" + qxsuoding + ", jename=" + jename + ", juese=" + juese + "]";
}

}
