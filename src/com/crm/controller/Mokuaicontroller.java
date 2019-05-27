package com.crm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Fenye;
import com.crm.entity.Mokuai;
import com.crm.entity.Mokuaigl;
import com.crm.entity.Teacher;
import com.crm.service.MokuaiMapperService;


@Controller
public class Mokuaicontroller {
	@Resource
	private MokuaiMapperService mapperService;
	@Autowired
	private Fenye<Mokuai> fenye;

	

	@RequestMapping(value = "/showMokuai", method = RequestMethod.POST)
	@ResponseBody
	public Fenye<Mokuai> showMokuai(HttpServletRequest request) {

		fenye = mapperService.selectMk(fenye);
		return fenye;
	}

	@RequestMapping(value = "/insertMk",method = RequestMethod.POST)
	@ResponseBody
	public Integer insertMk(Mokuai mokuai) {

		return mapperService.insertMk(mokuai);
	}
    @RequestMapping(value = "/updateMk",method = RequestMethod.POST)
    @ResponseBody
	public Integer updateMk(Mokuai mokuai) {

		return mapperService.updaeMK(mokuai);
	}

	public Integer deleteMk() {

		return null;
	}

}
