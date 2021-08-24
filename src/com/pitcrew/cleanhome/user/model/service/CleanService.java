package com.pitcrew.cleanhome.user.model.service;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.user.model.dao.CleanDAO;
import com.pitcrew.cleanhome.user.model.dto.CleanDTO;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

public class CleanService {
	
	private final CleanDAO cleanDAO;
	
	public CleanService() {
		
	cleanDAO = new CleanDAO();
	}
	
	/* 청소 정보 조회 메소드 */
	public CleanDTO selectClean(int num) {
		
		SqlSession session = getSqlSession();
		CleanDTO clean = null;
		
		clean = cleanDAO.selectClean(session, num);
		
		session.close();
		
		return clean;
	}
	
	/* 회원 정보 조회 메소드 */
	public CleanDTO selectMember(MemberDTO member) {
		
		SqlSession session = getSqlSession();
		CleanDTO clean = null;
		
		clean = cleanDAO.selectMember(session, member);
		
		session.close();
		
		return clean;
	}

}
