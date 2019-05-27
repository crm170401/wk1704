package com.crm.service;

import java.util.List;

import com.crm.entity.Shu;

public interface ShuService {

	List<Shu> selectFuTree(String name);

	List<Shu> selectZiTree(int id, String name);
}
