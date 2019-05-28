package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Juese;
import com.crm.service.JueseMapperService;

@Controller
public class JueseController {
	@Autowired
	private JueseMapperService juesemapperservice;
	@RequestMapping(value="alljuese",method = RequestMethod.POST)
	@ResponseBody
	private List<Juese> selectJuese() {	
		return juesemapperservice.selectJuese();
	}
	@RequestMapping(value="insertjuese",method = RequestMethod.POST)
	@ResponseBody
	private Integer insertJuese(String jename) {	
		Integer num=juesemapperservice.insertJuese(jename);
		return num;
	}
	@RequestMapping(value="deletejuese",method = RequestMethod.POST)
	@ResponseBody
	private Integer deleteJuese(Integer jeid) {	
		Integer num=juesemapperservice.deleteJuese(jeid);
		return num;
	}
}
