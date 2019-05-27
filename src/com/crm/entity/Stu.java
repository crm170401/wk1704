package com.crm.entity;

import org.springframework.stereotype.Component;

@Component
public class Stu {
	private Integer stuid;
	private String sname;
	private String ssex;
	private String saddress;
	private Integer sqingkuang;
	private Integer suoshujiaoshi;
	private String slianxi;
	private String semail;
	private String sweixin;
	private String sqq;
	private Integer skecheng;
	private String sshifouyouxiao;
	private String swuxiaoyuanyin;
	private String sjiaofei;
	private String sjiaofeishijian;
	private String sbaobei;
	private String sdingjin;
	private String sdingjinshijian;
	private String slururen;
	private Teacher teacher;
	private Kecheng kecheng;
	private Stuqk stuqk;
	private HuiFang huiFang;
	
	
	public Stuqk getStuqk() {
		return stuqk;
	}
	public void setStuqk(Stuqk stuqk) {
		this.stuqk = stuqk;
	}
	public HuiFang getHuiFang() {
		return huiFang;
	}
	public void setHuiFang(HuiFang huiFang) {
		this.huiFang = huiFang;
	}
	public Kecheng getKecheng() {
		return kecheng;
	}
	public void setKecheng(Kecheng kecheng) {
		this.kecheng = kecheng;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Integer getStuid() {
		return stuid;
	}
	public void setStuid(Integer stuid) {
		this.stuid = stuid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public Integer getSqingkuang() {
		return sqingkuang;
	}
	public void setSqingkuang(Integer sqingkuang) {
		this.sqingkuang = sqingkuang;
	}
	public Integer getSuoshujiaoshi() {
		return suoshujiaoshi;
	}
	public void setSuoshujiaoshi(Integer suoshujiaoshi) {
		this.suoshujiaoshi = suoshujiaoshi;
	}
	public String getSlianxi() {
		return slianxi;
	}
	public void setSlianxi(String slianxi) {
		this.slianxi = slianxi;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSweixin() {
		return sweixin;
	}
	public void setSweixin(String sweixin) {
		this.sweixin = sweixin;
	}
	public String getSqq() {
		return sqq;
	}
	public void setSqq(String sqq) {
		this.sqq = sqq;
	}
	public Integer getSkecheng() {
		return skecheng;
	}
	public void setSkecheng(Integer skecheng) {
		this.skecheng = skecheng;
	}
	public String getSshifouyouxiao() {
		return sshifouyouxiao;
	}
	public void setSshifouyouxiao(String sshifouyouxiao) {
		this.sshifouyouxiao = sshifouyouxiao;
	}
	public String getSwuxiaoyuanyin() {
		return swuxiaoyuanyin;
	}
	public void setSwuxiaoyuanyin(String swuxiaoyuanyin) {
		this.swuxiaoyuanyin = swuxiaoyuanyin;
	}
	public String getSjiaofei() {
		return sjiaofei;
	}
	public void setSjiaofei(String sjiaofei) {
		this.sjiaofei = sjiaofei;
	}
	public String getSjiaofeishijian() {
		return sjiaofeishijian;
	}
	public void setSjiaofeishijian(String sjiaofeishijian) {
		this.sjiaofeishijian = sjiaofeishijian;
	}
	public String getSbaobei() {
		return sbaobei;
	}
	public void setSbaobei(String sbaobei) {
		this.sbaobei = sbaobei;
	}
	public String getSdingjin() {
		return sdingjin;
	}
	public void setSdingjin(String sdingjin) {
		this.sdingjin = sdingjin;
	}
	public String getSdingjinshijian() {
		return sdingjinshijian;
	}
	public void setSdingjinshijian(String sdingjinshijian) {
		this.sdingjinshijian = sdingjinshijian;
	}
	public String getSlururen() {
		return slururen;
	}
	public void setSlururen(String slururen) {
		this.slururen = slururen;
	}
	@Override
	public String toString() {
		return "Stu [stuid=" + stuid + ", sname=" + sname + ", ssex=" + ssex + ", saddress=" + saddress
				+ ", sqingkuang=" + sqingkuang + ", suoshujiaoshi=" + suoshujiaoshi + ", slianxi=" + slianxi
				+ ", semail=" + semail + ", sweixin=" + sweixin + ", sqq=" + sqq + ", skecheng=" + skecheng
				+ ", sshifouyouxiao=" + sshifouyouxiao + ", swuxiaoyuanyin=" + swuxiaoyuanyin + ", sjiaofei=" + sjiaofei
				+ ", sjiaofeishijian=" + sjiaofeishijian + ", sbaobei=" + sbaobei + ", sdingjin=" + sdingjin
				+ ", sdingjinshijian=" + sdingjinshijian + ", slururen=" + slururen + ", teacher=" + teacher
				+ ", kecheng=" + kecheng + ", stuqk=" + stuqk + ", huiFang=" + huiFang + "]";
	}
	
	
	
	
	
	
	
	
}
