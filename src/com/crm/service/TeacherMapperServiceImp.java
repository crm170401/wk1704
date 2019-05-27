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
import com.crm.entity.Fenye;
import com.crm.entity.Juese;
import com.crm.entity.Quanxian;
import com.crm.entity.Teacher;
import com.crm.until.Md5Util;

@Service
public class TeacherMapperServiceImp implements TeacherMapperService {
	@Autowired
	private TeacherMapper teachermapper;
	@Autowired
	private MokuaiJueseMapper mkjsmapper;
	Md5Util md5=new Md5Util();
	@Override
	public Integer TcLogin(Teacher teacher,String verifyCode) {
		// TODO Auto-generated method stub
		Integer num = null;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession(false);
		String input = verifyCode;
		String vcode = (String) request.getSession().getAttribute("code");
		// 忽略大小写比较
		boolean flag = input.equalsIgnoreCase(vcode);

		if (flag == true) {
			String password=teacher.getTeachpassword();
			String passwordmd5=md5.getMD5(password);
			teacher.setTeachpassword(passwordmd5);
			num = teachermapper.selectTcLogin(teacher);
			if (num > 0) {
				List<Quanxian> qx = selectTcQuanXian(teacher);
				Integer sd = qx.get(0).getQxsuoding();
				List<Teacher> teacherid=teachermapper.selectTcId(teacher);
				if (sd == 0) {
					num = 0;
					session.setAttribute("teacherid", teacherid.get(0).getTeacherid());
					Integer id=(Integer) session.getAttribute("teacherid");
					List<Teacher> listteid=teachermapper.selectTcById(id);
					Integer qz=Integer.parseInt(listteid.get(0).getTeachquanzhong());
					session.setAttribute("teachname", listteid.get(0).getTeachname());
					List<Juese> listjuese=mkjsmapper.selectByIdJuese(qz);
					session.setAttribute("jsdelete",listjuese.get(0).getJedelete());
					session.setAttribute("jsupdate",listjuese.get(0).getJeupdate());
					session.setAttribute("jsinsert",listjuese.get(0).getJeinsert());
					Integer zt=updateTcZhuangTai(qx.get(0).getQxuserid());
				} else {
					num = 1;// 该用户已被锁定
				}
			} else {
				num = 2;// 用户名或密码错误
			}
		} else {
			num = 3;//验证码错误
		}

		return num;
	}

	@Override
	public List<Quanxian> selectTcQuanXian(Teacher teacher) {
		// TODO Auto-generated method stub
		List<Quanxian> qx = teachermapper.selectTcQuanXian(teacher);
		return qx;
	}

	@Override
	public Integer updateTcZhuangTai(Integer teacherid) {
		// TODO Auto-generated method stub
		return teachermapper.updateTcZhuangTai(teacherid);
	}

	@Override
	public Fenye<Teacher> getTeacherData(Fenye<Teacher> fenye) {
		// TODO Auto-generated method stub
		Integer Count=teachermapper.selectTeacherDataCount(fenye);
		List<Teacher> rows=teachermapper.selectTeacherData(fenye);
		fenye.setCount(Count);
		fenye.setRows(rows);
		return fenye;
	}

	@Override
	public Integer deleteTeacherById(Integer teacherid) {
		// TODO Auto-generated method stub
		Integer res=teachermapper.deleteTeacherById(teacherid);
		return res;
	}

	@Override
	public Integer deleteTeachQxById(Integer teacherid) {
		// TODO Auto-generated method stub
		Integer qx=teachermapper.deleteTeachQxById(teacherid);
		return qx;
	}

	@Override
	public Integer updateQxSuoDing(Integer teacherid) {
		// TODO Auto-generated method stub
		Integer suoding=teachermapper.updateQxSuoDing(teacherid);
		return suoding;
	}

	@Override
	public Integer updateQxJieSuo(Integer teacherid) {
		// TODO Auto-generated method stub
		Integer jiesuo=teachermapper.updateQxJieSuo(teacherid);
		return jiesuo;
	}

	@Override
	public Integer insertTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		String password=teacher.getTeachpassword();
		String passwordmd5=md5.getMD5(password);
		teacher.setTeachpassword(passwordmd5);
		Integer num=teachermapper.insertTeacher(teacher);
		return num;
	}

	@Override
	public Integer insertTeacherQx(Integer teacherid) {
		// TODO Auto-generated method stub
		Integer num=teachermapper.insertTeacherQx(teacherid);
		return num;
	}

	@Override
	public Integer selectNewTeacherId(Teacher teacher) {
		// TODO Auto-generated method stub
		Integer num=teachermapper.selectNewTeacherId(teacher);
		return num;
	}

	@Override
	public Integer updateTeachById(Teacher teacher) {
		// TODO Auto-generated method stub
		String password=teacher.getTeachpassword();
		String passwordmd5=md5.getMD5(password);
		teacher.setTeachpassword(passwordmd5);
		Integer num=teachermapper.updateTeachById(teacher);
		return num;
	}
	
}
