package com.crm.service;

import java.util.List;

import com.crm.entity.Juese;

public interface JueseMapperService {
	List<Juese> selectJuese();
	Integer insertJuese(String jename);
	Integer deleteJuese(Integer id);//删除角色
}
