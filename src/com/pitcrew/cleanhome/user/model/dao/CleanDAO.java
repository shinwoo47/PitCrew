package com.pitcrew.cleanhome.user.model.dao;

import com.pitcrew.cleanhome.user.model.dto.CleanDTO;

import org.apache.ibatis.session.SqlSession;

public class CleanDAO {

	public CleanDTO selectClean(SqlSession session, int num) {
		
		System.out.println("dao호출");
		return session.selectOne("CleanDAO.selectClean", num);
	}

}
