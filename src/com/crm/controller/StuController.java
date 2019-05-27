package com.crm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Fenye;
import com.crm.entity.HuiFang;
import com.crm.entity.Stu;
import com.crm.entity.Stuqk;
import com.crm.service.StuMapperService;

@Controller
public class StuController {

	@Autowired
	private Stu stu;

	@Autowired
	private Fenye fenye;

	@Autowired
	private StuMapperService stuMapperSxervice;

	@RequestMapping(value = "/AllStu")
	@ResponseBody
	public Fenye<Stu> selectAll(Integer page, Integer rows,Stu stu) {
		System.out.println(stu);
//		Integer teacherid=(Integer) session.getAttribute("teacherid");
		
		fenye.setPage((page - 1) * rows);
		fenye.setPageSize(rows);
		fenye.setShiti(stu);
		fenye = stuMapperSxervice.selectAllStu(fenye);
		
		return fenye;
	}

	
	  @RequestMapping(value="/AllStuqk")
	  @ResponseBody
	  public Fenye<Stuqk> selectAllqk(Integer page, Integer rows,Integer sqstuid,String shijian,String timeup,String timedown)  {
		  fenye.setPage((page-1)*rows); 
		  fenye.setPageSize(rows);
		  fenye.setShiti(sqstuid);
  		  fenye=stuMapperSxervice.selectAllStuqk(fenye);
		  
		  return fenye; 
	  }
	  
	  @RequestMapping(value="/AllStuhf")
	  @ResponseBody
	  public Fenye<HuiFang> selectAllhf(Integer page, Integer rows,Integer hfxueshengid){
		  fenye.setPage((page-1)*rows); 
		  fenye.setPageSize(rows);
		  fenye.setShiti(hfxueshengid);
		  fenye=stuMapperSxervice.selectAllhf(fenye);
		  System.out.println(fenye);
		return fenye;
		  
	  }
	 
}
