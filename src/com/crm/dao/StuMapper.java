package com.crm.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.crm.entity.Fenye;
import com.crm.entity.HuiFang;
import com.crm.entity.Stu;
import com.crm.entity.Stuqk;

public interface StuMapper {
	
	List<Stu> selectAllStu(Fenye<Stu> fenye);
	
	Integer SelectCountStu(Fenye<Stu> fenye);
	
	List<Stuqk> selectAllStuqk(Fenye<Stuqk> fenye);
	
	List<HuiFang> selectAllhf(Fenye<HuiFang> fenye);
}
