package com.crm.dao;

import java.util.List;

import com.crm.entity.Juese;

public interface JueseMapper {
List<Juese> selectJuese();
int selectChongMingJuese(String jename);//查询重名
Integer updateJuese(Juese js);
Integer insertJuese(String jename);//添加角色
int selectZhanYongJuese(Integer id);//查询占用
Integer deleteJuese(Integer id);//删除角色
}
