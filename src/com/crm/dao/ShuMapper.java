package com.crm.dao;

import java.util.List;

import com.crm.entity.Shu;

public interface ShuMapper {

	List<Shu> selectFuTree(String name);

	List<Shu> selectZiTree(int id, String name);
}
