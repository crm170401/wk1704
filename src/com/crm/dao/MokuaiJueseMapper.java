package com.crm.dao;

import java.util.List;

import com.crm.entity.Juese;
import com.crm.entity.Mokuai;
import com.crm.entity.Mokuaigl;

public interface MokuaiJueseMapper {
	/**
	 * 查询所有角色
	 * @return
	 */
List<Juese> selectAllJuese();
/**
 * 把用户权重作为条件查询角色/权限
 * @return
 */
List<Juese> selectByIdJuese(Integer id);
/**
 * 查询所有模块
 * @return
 */
List<Mokuai> selectAllMokuai();
/**
 * 修改角色的修改权限
 * @param num
 * @return
 */
Integer updateXiugai(Juese juese);
/**
 * 修改角色的添加权限
 * @param num
 * @return
 */
Integer updateTianjia(Juese juese);
/**
 * 修改角色的删除权限
 * @param num
 * @return
 */
Integer updateShanchu(Juese juese);
}
