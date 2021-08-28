package com.pitcrew.cleanhome.user.request.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.user.model.dto.CleanDTO;
import com.pitcrew.cleanhome.user.request.model.dto.UserRequestDTO;

public class UserReqDAO {
	
	/* 한 회원의 모든 의뢰 정보를 조회하는 메소드*/
	public List<UserRequestDTO> selectMyAllReq(SqlSession session, int memNoUser) {

		return session.selectList("UserReqDAO.selectMyAllReq", memNoUser);
		
	}
	
	/* 한 회원의 등록된 의뢰 정보를 조회하는 메소드*/
	public List<UserRequestDTO> myRegistRequest(SqlSession session, int memNoUser) {

		return session.selectList("UserReqDAO.myRegistRequest", memNoUser);
	}

	/* 한 회원의 매칭 완료된 의뢰 정보를 조회하는 메소드*/
	public List<UserRequestDTO> compRegistReq(SqlSession session, int memNoUser) {

		return session.selectList("UserReqDAO.compRegistReq", memNoUser);
	}
	
	/* 한 회원의 종료된 의뢰 정보를 조회하는 메소드 */
	public List<UserRequestDTO> myeEndRequest(SqlSession session, int memNoUser) {
		
		return session.selectList("UserReqDAO.myeEndRequest", memNoUser);
	}
	
	/* 회원 의뢰 상세보기를 조회하는 메소드 */
	public UserRequestDTO selectRequestDetail(SqlSession session, UserRequestDTO userRequestDTO) {

		return session.selectOne("UserReqDAO.selectRequestDetail", userRequestDTO);
	}

}
