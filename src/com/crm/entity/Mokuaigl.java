package com.crm.entity;

import org.springframework.stereotype.Component;

@Component
public class Mokuaigl {
private Integer mkglid;
private Integer mkjueseid;
private Integer mkid;
public Integer getMkjueseid() {
	return mkjueseid;
}
public void setMkjueseid(Integer mkjueseid) {
	this.mkjueseid = mkjueseid;
}
public Integer getMkid() {
	return mkid;
}
public void setMkid(Integer mkid) {
	this.mkid = mkid;
}
public Integer getMkglid() {
	return mkglid;
}
public void setMkglid(Integer mkglid) {
	this.mkglid = mkglid;
}
@Override
public String toString() {
	return "Mokuaigl [mkglid=" + mkglid + ", mkjueseid=" + mkjueseid + ", mkid=" + mkid + "]";
}



}
