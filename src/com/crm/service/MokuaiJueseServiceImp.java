package com.crm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.crm.dao.MokuaiJueseMapper;
import com.crm.dao.TeacherMapper;
import com.crm.entity.Juese;
import com.crm.entity.Teacher;
@Service
public class MokuaiJueseServiceImp implements MokuaiJueseService{
	@Autowired
	private MokuaiJueseMapper mkjsmapper;
	@Autowired
	private TeacherMapper teachermapper;
	@Override
	public List<Juese> selectAlljuese() {
		// TODO Auto-generated method stub
		List<Juese> listjuese=mkjsmapper.selectAllJuese();
		return listjuese;
	}
	@Override
	public Integer updateTianjia(Juese juese) {
		// TODO Auto-generated method stub
		Integer num=mkjsmapper.updateTianjia(juese);
		reset();
		return num;
	}
	@Override
	public Integer updateXiugai(Juese juese) {
		// TODO Auto-generated method stub
		Integer num=mkjsmapper.updateXiugai(juese);
		reset();
		return num;
	}
	@Override
	public Integer updateShanchu(Juese juese) {
		// TODO Auto-generated method stub
		Integer num=mkjsmapper.updateShanchu(juese);
		reset();
		return num;
	}
	public String reset() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession(false);
		Integer id=(Integer) session.getAttribute("teacherid");
		List<Teacher> listteid=teachermapper.selectTcById(id);
		Integer qz=Integer.parseInt(listteid.get(0).getTeachquanzhong());
		List<Juese> listjuese=mkjsmapper.selectByIdJuese(qz);
		session.setAttribute("jsdelete",listjuese.get(0).getJedelete());
		session.setAttribute("jsupdate",listjuese.get(0).getJeupdate());
		session.setAttribute("jsinsert",listjuese.get(0).getJeinsert());
		return null;
	}

}
