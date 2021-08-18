package com.pitcrew.cleanhome.user.request.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.user.model.dto.CleanDTO;
import com.pitcrew.cleanhome.user.request.model.dto.UserRequestDTO;

public class UserReqDAO {

	public List<UserRequestDTO> selectMyAllReq(SqlSession session, int memNoUser) {

		return session.selectList("UserReqDAO.selectMyAllReq", memNoUser);
		
	}

	public List<UserRequestDTO> myRegistRequest(SqlSession session, int memNoUser) {

		return session.selectList("UserReqDAO.myRegistRequest", memNoUser);
	}


	public List<UserRequestDTO> compRegistReq(SqlSession session, int memNoUser) {

		return session.selectList("UserReqDAO.compRegistReq", memNoUser);
	}
	
	public List<UserRequestDTO> myeEndRequest(SqlSession session, int memNoUser) {
		
		return session.selectList("UserReqDAO.myeEndRequest", memNoUser);
	}

	public String selectRequestStatus(SqlSession session, UserRequestDTO userRequestDTO) {
		
		return session.selectOne("UserReqDAO.selectRequestStatus", userRequestDTO);
	}

	public UserRequestDTO selectRequestDetail(SqlSession session, UserRequestDTO userRequestDTO) {

		return session.selectOne("UserReqDAO.selectRequestDetail", userRequestDTO);
	}

}
