package com.crm.dao;

import java.util.List;

import com.crm.entity.Fenye;
import com.crm.entity.Mokuai;
import com.crm.entity.Mokuaigl;

public interface MokuaiMapper {
	
	List<Mokuai> selectMoKuai(Fenye<Mokuai> fenye);

	Integer selectCountMk(Fenye<Mokuai> fenye);

	Integer insertMK(Mokuai mokuai);

	Integer updateMk(Mokuai mokuai);

	Integer deleteMk(Integer id);
}
