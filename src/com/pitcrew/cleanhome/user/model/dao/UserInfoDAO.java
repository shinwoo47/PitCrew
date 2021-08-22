package com.pitcrew.cleanhome.user.model.dao;

import java.util.List; 

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
 
public class UserInfoDAO {

	public List<MemberDTO> selectMyInfo(SqlSession session, int memNo) {
		
		return session.selectList("UserInfoDAO.selectMyInfo", memNo);
	}

	public List<MemberDTO> selectUpdateMyInfo(SqlSession session, int memNo) {
		
		return session.selectList("UserInfoDAO.selectUpdateMyInfo", memNo);
	}

	public int updateMyInfo(SqlSession session, MemberDTO updateMember) {

		return session.update("UserInfoDAO.updateMyInfo", updateMember);
	}

	public int quitMember(SqlSession session, MemberDTO member) {
		
		return session.update("UserInfoDAO.quitMember", member);
	}

}
