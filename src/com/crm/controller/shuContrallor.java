package com.crm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Shu;
import com.crm.service.ShuService;
import com.crm.until.CookiesUtil;

@Controller
public class shuContrallor {

	@Resource
	private ShuService shuService;
	
	@Resource
	private CookiesUtil cookiesutil;

	@RequestMapping(value = "/getShu", method = RequestMethod.POST)
	@ResponseBody
	public List<Shu> getShu(HttpSession httpSession) {
		String name = (String) httpSession.getAttribute("teachname");
		
		List<Shu> selectFuTree = shuService.selectFuTree(name);
		return getshuzhi(selectFuTree, name);
	}

	public List<Shu> getshuzhi(List<Shu> list, String name) {
		for (Shu shu : list) {
			List<Shu> selectZiTree = shuService.selectZiTree(shu.getId(), name);
			if (selectZiTree.isEmpty()) {

			} else {
				getshuzhi(selectZiTree, name);
				shu.setChildren(selectZiTree);
			}
		}
		System.out.println(list);
		return list;
	}

	/*
	 * @RequestMapping(value = "/qingkong", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public String qingkong(HttpServletRequest
	 * request,HttpServletResponse response) {
	 * request.getSession().setAttribute("teacherid", null);
	 * request.getSession().setAttribute("teachname", null);
	 * cookiesutil.setCookie(response, "", "", 0); cookiesutil.setCookie(response,
	 * "", "", 0); return null; }
	 */
}
