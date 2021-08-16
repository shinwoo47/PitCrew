package com.pitcrew.cleanhome.user.model.dao;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.user.model.dto.CleanDTO;

import org.apache.ibatis.session.SqlSession;

public class CleanDAO {

	public CleanDTO selectClean(SqlSession session, int num) {
		
		return session.selectOne("CleanDAO.selectClean", num);
	}

	public CleanDTO selectMember(SqlSession session, MemberDTO member) {
		
		return session.selectOne("CleanDAO.selectUser", member.getMemNo());
	}

}
