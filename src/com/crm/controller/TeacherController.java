package com.crm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.crm.entity.Fenye;
import com.crm.entity.Teacher;
import com.crm.service.TeacherMapperService;

@Controller
public class TeacherController {
	@Autowired
	private TeacherMapperService teachermapperservice;
	@Autowired
	private Fenye<Teacher> fenye;
	@RequestMapping(value="/teacherData",method = RequestMethod.POST)
	@ResponseBody
	public Fenye<Teacher> getTeacherData(Teacher teacher,Integer page,Integer rows){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession(false);
		
		fenye.setShiti(teacher);
		fenye.setPage((page-1)*rows);
		fenye.setPageSize(rows);
		fenye=teachermapperservice.getTeacherData(fenye);
		return fenye;
	}
	@RequestMapping(value="/deleteTeach",method = RequestMethod.POST)
	@ResponseBody
	public String deleteTeach(Integer teacherid) {
		Integer num1=teachermapperservice.deleteTeacherById(teacherid);
		Integer num2=teachermapperservice.deleteTeachQxById(teacherid);
		String res=null;
		if(num1>0 && num2>0) {
			res="删除成功";
		}else {
			res="删除错误，请与管理员联系";
		}
		return res;
	}
	@RequestMapping(value="/SuoDing",method = RequestMethod.POST)
	@ResponseBody
	public String SuoDing(Integer teacherid) {
		String message=null;
		Integer res=teachermapperservice.updateQxSuoDing(teacherid);
		if(res>0) {
			message="修改成功";
		}else {
			message="修改失败";
		}
		return message;
	}
	@RequestMapping(value="/JieSuo",method = RequestMethod.POST)
	@ResponseBody
	public String JieSuo(Integer teacherid) {
		String message=null;
		Integer res=teachermapperservice.updateQxJieSuo(teacherid);
		if(res>0) {
			message="修改成功";
		}else {
			message="修改失败";
		}
		return message;
	}
	@RequestMapping(value="/insertTeach",method = RequestMethod.POST)
	@ResponseBody
	public String insertTeach(Teacher teacher) {
		String message=null;
		Integer res=teachermapperservice.insertTeacher(teacher);
		Integer id=teachermapperservice.selectNewTeacherId(teacher);
		Integer num=teachermapperservice.insertTeacherQx(id);
		if(num>0) {
			message="添加成功";
		}else {
			message="添加失败";
		}
		return message;
	}
	@RequestMapping(value="/updateTeachById",method = RequestMethod.POST)
	@ResponseBody
	public String updateTeachById(Teacher teacher) {
		String message=null;
		Integer num=teachermapperservice.updateTeachById(teacher);
		if(num>0) {
			message="修改成功";
		}else {
			message="修改失败";
		}
		return message;
	}
}
