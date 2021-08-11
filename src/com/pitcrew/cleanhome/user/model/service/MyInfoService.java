package com.pitcrew.cleanhome.user.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.user.model.dao.UserInfoDAO;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

public class MyInfoService {

	private final UserInfoDAO userInfoDAO;
	
	public MyInfoService() {
		
		userInfoDAO =  new UserInfoDAO();
		
	}
	
	public List<MemberDTO> selectMyInfo(int memNo) {

		SqlSession session = getSqlSession();
		
		List<MemberDTO> selectMyInfo = userInfoDAO.selectMyInfo(session, memNo);
		
		session.close();
		
		return selectMyInfo;
	}

	public List<MemberDTO> selectUpdateMyInfo(int memNo) {
		
		SqlSession session = getSqlSession();
		
		List<MemberDTO> selectUpdateMyInfo = userInfoDAO.selectUpdateMyInfo(session, memNo);
		
		session.close();
		
		return selectUpdateMyInfo;
	}

	public int updateMyInfo(MemberDTO updateMember) {
		
		SqlSession session = getSqlSession();
		
		int result = userInfoDAO.updateMyInfo(session, updateMember);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
	
	
}
