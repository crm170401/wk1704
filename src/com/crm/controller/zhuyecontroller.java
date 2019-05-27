package com.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Mokuai;
import com.crm.service.Zhuyeservice;
import com.crm.service.shuzhuangtuservice;
import com.crm.until.CookiesUtil;
import com.sun.org.apache.regexp.internal.recompile;

@Controller
public class zhuyecontroller {

	@Autowired
	private shuzhuangtuservice shuzhuangtu;

	@Autowired
	CookiesUtil cookiesutil;

	@Autowired
	Zhuyeservice zhuyeservice;

	@RequestMapping(value = "/showMK", method = RequestMethod.POST)
	@ResponseBody
	public List<Mokuai> showMK(HttpServletRequest httpServletRequest) {

		Integer id = (Integer) httpServletRequest.getAttribute("teacherid");

		return shuzhuangtu.selectByid(id);
	}

	@RequestMapping(value = "/zhuyeliebiao", method = RequestMethod.GET)
	@ResponseBody
	public String zhuyeliebiao(String treeUlId, HttpServletRequest request) {
		String zhuyeshu = zhuyeservice.zhuyeshu(treeUlId, request);
		return zhuyeshu;
	}


}
