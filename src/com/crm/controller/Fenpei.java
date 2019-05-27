package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.crm.entity.Stu;
import com.crm.service.FenpeiMapperService;

@Controller
public class Fenpei {
	
	@Autowired
	private Stu stu;
	
	@Autowired
	private FenpeiMapperService fenpeiMapperService;
	
	@RequestMapping(value="/zidong")
	@ResponseBody
	public boolean fenpeizidong(Integer stuid) {
		stu.setStuid(stuid);
		String mana="6666";
		
		boolean updatezidong = fenpeiMapperService.updatezidong(stuid);
		
		return updatezidong;
	}
	
	
	@RequestMapping(value="/shoudong")
	@ResponseBody
	public boolean fenpeishoudong(Integer stuid,Integer suoshujiaoshi) {
		stu.setStuid(stuid);
		stu.setSuoshujiaoshi(suoshujiaoshi);
		
		boolean updateshoudong = fenpeiMapperService.updateshoudong(stuid, suoshujiaoshi);
		
		return updateshoudong;
		
	}
	
	
}
