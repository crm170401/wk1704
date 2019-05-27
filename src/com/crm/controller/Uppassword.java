package com.crm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.service.UppasswordMapperService;

@Controller
public class Uppassword {
	
	@Autowired
	UppasswordMapperService uppasswordMapperService;
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping(value="/xiugaimima")
	@ResponseBody
	public Integer xiugaimima(String oldpassword,String newpassword){
		
		Object attribute =session.getAttribute("teacherid");
		Integer teacherid=(Integer.parseInt(attribute.toString()));
//		System.out.println(attribute.toString());
		
		Integer xiugaimima = uppasswordMapperService.xiugaimima(oldpassword, newpassword,teacherid);
		return xiugaimima;
		
	}
}
