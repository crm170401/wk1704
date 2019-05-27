package com.crm.service;

import com.crm.entity.Fenye;
import com.crm.entity.HuiFang;

public interface HuiFangMapperService {

	Fenye<HuiFang> selectHF(Fenye<HuiFang> fenye);

	Integer insertHF(HuiFang fang);
}
