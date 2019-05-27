package com.crm.service;

import javax.servlet.http.HttpSession;

import com.crm.entity.Fenye;
import com.crm.entity.HuiFang;
import com.crm.entity.Stu;
import com.crm.entity.Stuqk;

public interface StuMapperService {
	Fenye<Stu> selectAllStu(Fenye<Stu> fenye);
	
	
	Fenye<Stuqk> selectAllStuqk(Fenye<Stuqk> fenye);
	
	Fenye<HuiFang> selectAllhf(Fenye<HuiFang> fenye);


}
