package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Juese;
import com.crm.service.MokuaiJueseService;

@Controller
public class MokuaiJueseController {
	
	@Autowired
	private MokuaiJueseService mkjsservice;
	
	@RequestMapping(value="/Alljuse",method = RequestMethod.POST)
	@ResponseBody
	List<Juese> selectAlljuese(){
		return mkjsservice.selectAlljuese();
	}
	@RequestMapping(value="/juseTianjia",method = RequestMethod.POST)
	@ResponseBody
	String juseTianjia(Juese juese,Integer pd){
		String message=null;
		if(pd==1) {
			juese.setJeinsert("0");
		}else {
			juese.setJeinsert("1");
		}
		Integer num=mkjsservice.updateTianjia(juese);
		if(num>0) {
			message="修改成功";
		}else {
			message="修改失败";
		}
		return message;
	}
	@RequestMapping(value="/juseXiugai",method = RequestMethod.POST)
	@ResponseBody
	String juseXiugai(Juese juese,Integer pd){
		String message=null;
		System.out.println(pd);
		if(pd==1) {
			juese.setJeupdate("0");;
		}else {
			juese.setJeupdate("1");
		}
		Integer num=mkjsservice.updateXiugai(juese);
		if(num>0) {
			message="修改成功";
		}else {
			message="修改失败";
		}
		return message;
	}
	@RequestMapping(value="/juseShanchu",method = RequestMethod.POST)
	@ResponseBody
	String juseShanchu(Juese juese,Integer pd){
		String message=null;
		if(pd==1) {
			juese.setJedelete("0");
		}else {
			juese.setJedelete("1");
		}
		Integer num=mkjsservice.updateShanchu(juese);
		if(num>0) {
			message="修改成功";
		}else {
			message="修改失败";
		}
		return message;
	}

}
