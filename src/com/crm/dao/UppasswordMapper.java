package com.crm.dao;

import org.apache.ibatis.annotations.Param;

public interface UppasswordMapper {
	Integer upmima(@Param("md5")String md5,@Param("teacherid")Integer teacherid);
	
	Integer selectmima(@Param("oldpassword")String oldpassword,@Param("teacherid")Integer teacherid);
}
