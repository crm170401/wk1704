package com.crm.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.FenpeiMapper;

@Service
public class FenpeiMapperServiceImp implements FenpeiMapperService {

	@Autowired
	private FenpeiMapper fenpeiMapper;

	@Override
	public boolean updatezidong(Integer stuid) {
		// TODO Auto-generated method stub
		Integer updatezidong = fenpeiMapper.updatezidong(stuid);
		if (updatezidong == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean updateshoudong(Integer stuid, Integer suoshujiaoshi) {
		// TODO Auto-generated method stub
		Integer updateshoudong = fenpeiMapper.updateshoudong(stuid, suoshujiaoshi);
		if (updateshoudong == 0) {
			return false;
		} else {
			return true;
		}

	}
	
}
