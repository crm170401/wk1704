package com.crm.dao;

import java.util.List;

import com.crm.entity.Fenye;
import com.crm.entity.HuiFang;

public interface HuiFangMapper {
	/**
	 * 查询回访表中的总条数
	 * 
	 * @param fenye
	 * @return
	 */
	Integer selcetCou(Fenye<HuiFang> fenye);

	/**
	 * 查询所有的回访记录
	 * 
	 * @param fenye
	 * @return
	 */
	List<HuiFang> selectHuifang(Fenye<HuiFang> fenye);

	/**
	 * 新增回访记录
	 * 
	 * @return
	 */
	Integer insertHui(HuiFang fang);
}
