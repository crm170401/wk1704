package com.crm.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.crm.dao.UppasswordMapper;
import com.crm.until.Md5Util;

@Service
public class UppasswordMapperServiceImp implements UppasswordMapperService{

	@Resource
	UppasswordMapper uppasswordMapper;
	
	
	@Override
	public Integer xiugaimima(String oldpassword, String newpassword,Integer teacherid) {
		// TODO Auto-generated method stub
		if(oldpassword==null || oldpassword=="") {
			return 0;//旧密码不能为空
		}
		
		if(newpassword==null || newpassword=="") {
			return 1;//请输入新密码
		}
			String md5 = Md5Util.getMD5(oldpassword);
			String md6 = Md5Util.getMD5(newpassword);
			Integer selectmima = uppasswordMapper.selectmima(md5,teacherid);
			if(selectmima==0) {
				return 2;//旧密码不正确
			}else {
				Integer upmima = uppasswordMapper.upmima(md6, teacherid);
				if(upmima==0) {
					return 3;//修改失败
				}else {
					return 4;//修改成功
				}
			}
			
		
	}

}
