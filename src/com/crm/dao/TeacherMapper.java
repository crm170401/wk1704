package com.crm.dao;

import java.util.List;

import com.crm.entity.Fenye;
import com.crm.entity.Quanxian;
import com.crm.entity.Teacher;

public interface TeacherMapper {
	/**
	 * 用户名登录
	 * @param String
	 * @return Integer
	 */
	Integer selectTcLogin(Teacher teacher);
	/**
	 * 用户权限是否锁定
	 * @param String
	 * @return Integer
	 */
	List<Quanxian> selectTcQuanXian(Teacher teacher);
	/**
	 * 查询用户id
	 * @param teacher
	 * @return
	 */
	List<Teacher> selectTcId(Teacher teacher);
	/**
	 * 根据id查询教师
	 * @param String
	 * @return Integer
	 */
	List<Teacher> selectTcById(Integer id);
	/**
	 * 修改用户状态为在线
	 * @param teacherid
	 * @return
	 */
	Integer updateTcZhuangTai(Integer teacherid);
	/**
	 * 分页条件查询所有数据
	 * @param fenye
	 * @return
	 */
	List<Teacher> selectTeacherData(Fenye fenye);
	/**
	 * 分页条件查询总条数
	 * @param fenye
	 * @return
	 */
	Integer selectTeacherDataCount(Fenye fenye);
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
