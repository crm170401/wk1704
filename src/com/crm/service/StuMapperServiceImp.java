package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.StuMapper;
import com.crm.entity.Fenye;
import com.crm.entity.HuiFang;
import com.crm.entity.Stu;
import com.crm.entity.Stuqk;

@Service
public class StuMapperServiceImp implements StuMapperService{
	
	@Autowired
	private StuMapper stuMapper;

	@Autowired
	private Fenye fenye;
	
	@Autowired
	private Stu stu;

	@Override
	public Fenye<Stu> selectAllStu(Fenye<Stu> fenye) {
		// TODO Auto-generated method stub
		
		
		List<Stu> selectAllStu = stuMapper.selectAllStu(fenye);
		
		Integer selectCountStu = stuMapper.SelectCountStu(fenye);
		fenye.setCount(selectCountStu);
		fenye.setRows(selectAllStu);
		return fenye;
	}

	@Override
	public Fenye<Stuqk> selectAllStuqk(Fenye<Stuqk> fenye) {
		// TODO Auto-generated method stub
		List<Stuqk> selectAllStuqk = stuMapper.selectAllStuqk(fenye); 
		fenye.setRows(selectAllStuqk);
		
		return fenye;
	}

	@Override
	public Fenye<HuiFang> selectAllhf(Fenye<HuiFang> fenye) {
		// TODO Auto-generated method stub
		
		List<HuiFang> selectAllhf = stuMapper.selectAllhf(fenye);
		fenye.setRows(selectAllhf);
		
		return fenye;
	}

}
