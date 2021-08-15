package com.pitcrew.cleanhome.user.request.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.user.request.model.dto.UserRequestDTO;

public class UserReqDAO {

	public List<UserRequestDTO> selectMyAllReq(SqlSession session, int memNoUser) {

		return session.selectList("UserReqDAO.selectMyAllReq", memNoUser);
		
	}

	public List<UserRequestDTO> myRegistRequest(SqlSession session, int memNoUser) {

		return session.selectList("UserReqDAO.myRegistRequest", memNoUser);
	}

}
