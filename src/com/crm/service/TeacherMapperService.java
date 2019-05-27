package com.crm.service;

import java.util.List;

import com.crm.entity.Fenye;
import com.crm.entity.Quanxian;
import com.crm.entity.Teacher;

public interface TeacherMapperService {
	/**
	 * 登录
	 * @return Integer
	 */
	Integer TcLogin(Teacher teacher,String verifyCode);
	/**
	 * 权限
	 * @param quanxian
	 * @return
	 */
	List<Quanxian> selectTcQuanXian(Teacher teacher);
	/**
	 * 修改用户状态
	 * @param teacherid
	 * @return
	 */
	Integer updateTcZhuangTai(Integer teacherid);
	/**
	 * 查询所有用户
	 * @param fenye
	 * @return
	 */
	Fenye<Teacher> getTeacherData(Fenye<Teacher> fenye);
	/**
	 * 根据id删除用户
	 * @param teacherid
	 * @return
	 */
	Integer deleteTeacherById(Integer teacherid);
	/**
	 * 根据id删除用户权限
	 * @param teacherid
	 * @return
	 */
	Integer deleteTeachQxById(Integer teacherid);
	
	/**
	 * 锁定用户
	 * @param teacherid
	 * @return
	 */
	Integer updateQxSuoDing(Integer teacherid);
	/**
	 * 解锁用户
	 * @param teacherid
	 * @return
	 */
	Integer updateQxJieSuo(Integer teacherid);
	/**
	 * 添加用户
	 * @param teacher
	 * @return
	 */
	Integer insertTeacher(Teacher teacher);
	/**
	 * 查询新添加用户的id
	 * @param teacher
	 * @return
	 */
	Integer selectNewTeacherId(Teacher teacher);
	/**
	 * 添加用户默认权限
	 * @return
	 */
	Integer insertTeacherQx(Integer teacherid);
	/**
	 * 修改用户信息
	 * @param teacher
	 * @return
	 */
	Integer updateTeachById(Teacher teacher);
}
