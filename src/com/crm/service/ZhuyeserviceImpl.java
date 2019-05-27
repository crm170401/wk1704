package com.crm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entity.Juese;
import com.crm.entity.Mokuai;
import com.crm.entity.Teacher;

@Service
public class ZhuyeserviceImpl implements Zhuyeservice {
	@Autowired
	private Mokuai mokuai;

	@Override
	public String zhuyeshu(String treeUlId, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		List<Juese> juese = teacher.getJuese();
		String jg = "<ul id=\"treeUlId\" class=\"easyui-tree\"><li>";
		for (int i = 0; i < juese.size(); i++) {
			List<Mokuai> mokuai2 = juese.get(i).getMokuai();
			for (int j = 0; j < mokuai2.size(); j++) {
				Mokuai mokuai3 = mokuai2.get(j);
				if (mokuai3.getMkjiedian() == 0) {
					jg = jg + "<span><atitle=\\\"\"+mokuai3.getMkid+\"\\\" onclick=\\\"navTab('\"+mokuai3.mkname()+\"','')\\\"> \"+mokuai3.mkname()+\"  < /a></span>";
					jg = shu(jg, mokuai2, mokuai3);
				}
			}
		}
		jg = jg + "</li></ul>";
		return jg;
	}

	public String shu(String jg, List<Mokuai> mokuai2, Mokuai mokuai3) {
		jg = jg + "<ul>";
		for (int i = 0; i < mokuai2.size(); i++) {
			mokuai = mokuai2.get(i);
			if (mokuai.getMkjiedian() == mokuai3.getMkid()) {
				jg = jg + "<li>";
				jg = jg + "<span><a title=\\\"\"+mokuai.getMkid()+\"\\\" onclick=\\\"navTab('\"+mokuai.mkname()+\"','\"+mokuai.mkzhixiang()+\"')\\\">\"+mokuai.mkname()+\"</a></span>";
				jg = jg + "</li>";
			}
		}
		jg=jg+"</ul>";
		return jg;
	}

}
