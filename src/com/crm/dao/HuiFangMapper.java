package com.crm.dao;

import java.util.List;

import com.crm.entity.Fenye;
import com.crm.entity.HuiFang;

public interface HuiFangMapper {
	/**
	 * ��ѯ�طñ��е�������
	 * 
	 * @param fenye
	 * @return
	 */
	Integer selcetCou(Fenye<HuiFang> fenye);

	/**
	 * ��ѯ���еĻطü�¼
	 * 
	 * @param fenye
	 * @return
	 */
	List<HuiFang> selectHuifang(Fenye<HuiFang> fenye);

	/**
	 * �����طü�¼
	 * 
	 * @return
	 */
	Integer insertHui(HuiFang fang);
}
