package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.shuzhuangtuMapper;
import com.crm.entity.Mokuai;


@Service
public class shuzhuangtuserviceImpl implements shuzhuangtuservice {

	@Autowired
	private shuzhuangtuMapper shuzhuangtuMapper;

	@Override
	public List<Mokuai> selectByid(Integer id) {
		// TODO Auto-generated method stub
		return shuzhuangtuMapper.selectTecaherByid(id);
	}

}
