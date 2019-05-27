package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.ShuMapper;
import com.crm.entity.Shu;

@Service
public class ShuServiceImpl implements ShuService {

	@Autowired
	private ShuMapper shuMapper;

	@Override
	public List<Shu> selectFuTree(String name) {
		// TODO Auto-generated method stub
		List<Shu> selectFuTree = shuMapper.selectFuTree(name);
		return selectFuTree;
	}

	@Override
	public List<Shu> selectZiTree(int id, String name) {
		// TODO Auto-generated method stub
		return shuMapper.selectZiTree(id, name);
	}

}
