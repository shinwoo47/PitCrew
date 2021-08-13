package com.pitcrew.cleanhome.user.model.service;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.user.model.dao.CleanDAO;
import com.pitcrew.cleanhome.user.model.dto.CleanDTO;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

public class CleanService {
	
	private final CleanDAO cleanDAO;
	
	public CleanService() {
		
	cleanDAO = new CleanDAO();
	}
	
	public CleanDTO selectClean(int num) {
		
		System.out.println("체크 1 ");
		SqlSession session = getSqlSession();
		System.out.println("체크 2 ");
		CleanDTO clean = null;
		
		clean = cleanDAO.selectClean(session, num);
		System.out.println("체크3");
		System.out.println("clean : " + clean);
		
		session.close();
		
		return clean;
	}

}
