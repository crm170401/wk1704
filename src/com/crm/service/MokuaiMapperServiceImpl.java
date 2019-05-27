package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.MokuaiMapper;
import com.crm.entity.Fenye;
import com.crm.entity.Mokuai;

@Service
public class MokuaiMapperServiceImpl implements MokuaiMapperService {

	@Autowired
	private MokuaiMapper mokuaiMapper;

	@Override
	public Fenye<Mokuai> selectMk(Fenye<Mokuai> fenye) {
		// TODO Auto-generated method stub
		Integer total = mokuaiMapper.selectCountMk(fenye);
		List<Mokuai> rows = mokuaiMapper.selectMoKuai(fenye);
		System.out.println(rows);
		fenye.setCount(total);
		fenye.setRows(rows);
		System.out.println(rows);
		return fenye;
	}

	@Override
	public Integer insertMk(Mokuai mokuai) {
		// TODO Auto-generated method stub

		return mokuaiMapper.insertMK(mokuai);
	}

	@Override
	public Integer updaeMK(Mokuai mokuai) {
		// TODO Auto-generated method stub
		Integer updateMk = mokuaiMapper.updateMk(mokuai);
		System.out.println(updateMk);
		return updateMk;
	}

	@Override
	public Integer deleteMK(Integer id) {
		// TODO Auto-generated method stub
		return mokuaiMapper.deleteMk(id);
	}

}
