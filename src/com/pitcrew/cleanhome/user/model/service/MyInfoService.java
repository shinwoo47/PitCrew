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
	
	/* 회원 정보 조회*/
	public List<MemberDTO> selectMyInfo(int memNo) {
		
		/* 회원 정보를 담은 리스트를 DAO에서 호출 */
		SqlSession session = getSqlSession();
		
		List<MemberDTO> selectMyInfo = userInfoDAO.selectMyInfo(session, memNo);
		
		session.close();
		
		return selectMyInfo;
	}
	
	/* 수정하기 페이지에서 조회할 회원정보*/
	public List<MemberDTO> selectUpdateMyInfo(int memNo) {
		
		SqlSession session = getSqlSession();
		
		List<MemberDTO> selectUpdateMyInfo = userInfoDAO.selectUpdateMyInfo(session, memNo);
		
		session.close();
		
		return selectUpdateMyInfo;
	}
	
	/* 수정한 회원정보 업데이트*/
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
