package com.crm.entity;

import org.springframework.stereotype.Component;

@Component
public class Kecheng {
	private Integer kcid;
	private String kcname;
	private Integer kcjiaoshi;
	private String kcxuefei;
	private String kctuifeishijian;
	public Integer getKcid() {
		return kcid;
	}
	public void setKcid(Integer kcid) {
		this.kcid = kcid;
	}
	public String getKcname() {
		return kcname;
	}
	public void setKcname(String kcname) {
		this.kcname = kcname;
	}
	public Integer getKcjiaoshi() {
		return kcjiaoshi;
	}
	public void setKcjiaoshi(Integer kcjiaoshi) {
		this.kcjiaoshi = kcjiaoshi;
	}
	public String getKcxuefei() {
		return kcxuefei;
	}
	public void setKcxuefei(String kcxuefei) {
		this.kcxuefei = kcxuefei;
	}
	public String getKctuifeishijian() {
		return kctuifeishijian;
	}
	public void setKctuifeishijian(String kctuifeishijian) {
		this.kctuifeishijian = kctuifeishijian;
	}
	@Override
	public String toString() {
		return "Kecheng [kcid=" + kcid + ", kcname=" + kcname + ", kcjiaoshi=" + kcjiaoshi + ", kcxuefei=" + kcxuefei
				+ ", kctuifeishijian=" + kctuifeishijian + "]";
	}
	
	
}
