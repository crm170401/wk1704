package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.JueseMapper;
import com.crm.entity.Juese;
@Service
public class JueseMapperServiceImp implements JueseMapperService{
	@Autowired
	private JueseMapper juesemapper;
	@Override
	public List<Juese> selectJuese() {
		// TODO Auto-generated method stub
		return juesemapper.selectJuese();
	}
	@Override
	public Integer insertJuese(String jename) {
		// TODO Auto-generated method stub
		Integer res=0;
		Integer num1=juesemapper.selectChongMingJuese(jename);
		if(num1>0) {
			res=0;//重复
		}else {
		Integer num2=juesemapper.insertJuese(jename);
			if(num2>0) {
				res=1;//添加成功
			}else {
				res=2;//添加失败
			}
		}
		return res;
	}
	@Override
	public Integer deleteJuese(Integer id) {
		// TODO Auto-generated method stub
		Integer res=0;
		Integer num1=juesemapper.selectZhanYongJuese(id);
		if(num1>0) {
			res=0;//占用
		}else {
		Integer num2=juesemapper.deleteJuese(id);
			if(num2>0) {
				res=1;//添加成功
			}else {
				res=2;//添加失败
			}
		}
		return res;
	}
}
