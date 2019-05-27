package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.HuiFangMapper;
import com.crm.entity.Fenye;
import com.crm.entity.HuiFang;
@Service
public class HuiFangMapperServiceImpl implements HuiFangMapperService {
   
	@Autowired
	private HuiFangMapper  HuiFangMapper;
	
	@Override
	public Fenye<HuiFang> selectHF(Fenye<HuiFang> fenye) {
		// TODO Auto-generated method stub
		Integer total = HuiFangMapper.selcetCou(fenye);
		List<HuiFang> rows = HuiFangMapper.selectHuifang(fenye);
		fenye.setCount(total);
		fenye.setRows(rows);
		return fenye;
	}

	@Override
	public Integer insertHF(HuiFang fang) {
		// TODO Auto-generated method stub
		return HuiFangMapper.insertHui(fang);
	}

}
