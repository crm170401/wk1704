package com.crm.entity;

import org.springframework.stereotype.Component;

@Component
public class HuiFang {
private Integer sid;
private String huifangshiji;
private Integer huifangren;
private String kehuyixiang;
private String kehudengji;
private Integer shifoushangmen;
private String shangmenqingkuang;
private Integer hfxueshengid;


public Integer getHfxueshengid() {
	return hfxueshengid;
}
public void setHfxueshengid(Integer hfxueshengid) {
	this.hfxueshengid = hfxueshengid;
}
public Integer getSid() {
	return sid;
}
public void setSid(Integer sid) {
	this.sid = sid;
}
public String getHuifangshiji() {
	return huifangshiji;
}
public void setHuifangshiji(String huifangshiji) {
	this.huifangshiji = huifangshiji;
}
public Integer getHuifangren() {
	return huifangren;
}
public void setHuifangren(Integer huifangren) {
	this.huifangren = huifangren;
}
public String getKehuyixiang() {
	return kehuyixiang;
}
public void setKehuyixiang(String kehuyixiang) {
	this.kehuyixiang = kehuyixiang;
}
public String getKehudengji() {
	return kehudengji;
}
public void setKehudengji(String kehudengji) {
	this.kehudengji = kehudengji;
}
public Integer getShifoushangmen() {
	return shifoushangmen;
}
public void setShifoushangmen(Integer shifoushangmen) {
	this.shifoushangmen = shifoushangmen;
}
public String getShangmenqingkuang() {
	return shangmenqingkuang;
}
public void setShangmenqingkuang(String shangmenqingkuang) {
	this.shangmenqingkuang = shangmenqingkuang;
}
@Override
public String toString() {
	return "HuiFang [sid=" + sid + ", huifangshiji=" + huifangshiji + ", huifangren=" + huifangren + ", kehuyixiang="
			+ kehuyixiang + ", kehudengji=" + kehudengji + ", shifoushangmen=" + shifoushangmen + ", shangmenqingkuang="
			+ shangmenqingkuang + ", hfxueshengid=" + hfxueshengid + "]";
}





}
