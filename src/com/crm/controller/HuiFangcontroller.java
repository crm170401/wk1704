package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Fenye;
import com.crm.entity.HuiFang;
import com.crm.service.HuiFangMapperService;

@Controller
public class HuiFangcontroller {

	@Autowired
	private HuiFangMapperService huifangMapperService;

	@Autowired
	private Fenye<HuiFang> fenye;

	@RequestMapping(value = "/showHuiFang", method = RequestMethod.POST)
	@ResponseBody
	public Fenye<HuiFang> showHuiFang(Integer page, Integer rows,HuiFang huiFang) {
		
		fenye.setPage((page - 1) * rows);
		fenye.setPageSize(rows);
		fenye.setShiti(huiFang);
		fenye = huifangMapperService.selectHF(fenye);
		return fenye;
	}
}
