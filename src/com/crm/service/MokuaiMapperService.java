package com.crm.service;

import com.crm.entity.Fenye;
import com.crm.entity.Mokuai;

public interface MokuaiMapperService {

	Fenye<Mokuai> selectMk(Fenye<Mokuai> fenye);

	Integer insertMk(Mokuai mokuai);

	Integer updaeMK(Mokuai mokuai);

	Integer deleteMK(Integer id);
}
