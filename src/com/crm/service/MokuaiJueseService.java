package com.crm.service;

import java.util.List;

import com.crm.entity.Juese;

public interface MokuaiJueseService {
	/**
	 * 查询所有角色
	 * @return
	 */
	List<Juese> selectAlljuese();
	/**
	 * 修改角色的添加权限
	 * @param num
	 * @return
	 */
	Integer updateTianjia(Juese juese);
	/**
	 * 修改角色的修改权限
	 * @param num
	 * @return
	 */
	Integer updateXiugai(Juese juese);
	/**
	 * 修改角色的删除权限
	 * @param num
	 * @return
	 */
	Integer updateShanchu(Juese juese);
}
