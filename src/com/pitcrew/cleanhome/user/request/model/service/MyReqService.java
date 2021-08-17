package com.pitcrew.cleanhome.user.request.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.user.request.model.dao.UserReqDAO;
import com.pitcrew.cleanhome.user.request.model.dto.UserRequestDTO;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

public class MyReqService {
	
	private final UserReqDAO userReqDAO;
	
	public MyReqService() {
		
		userReqDAO = new UserReqDAO();
		
	}

	public List<UserRequestDTO> selectMyAllReq(int memNoUser) {
		
		SqlSession session = getSqlSession();
		
		List<UserRequestDTO> selectMyAllReq = userReqDAO.selectMyAllReq(session, memNoUser);
		
		session.close();
		
		return selectMyAllReq;
	}

	public List<UserRequestDTO> myRegistRequest(int memNoUser) {

		SqlSession session = getSqlSession();
		
		List<UserRequestDTO> myRegistRequest = userReqDAO.myRegistRequest(session, memNoUser);
		
		session.close();
		
		return myRegistRequest;
	
	}

//	public UserRequestDTO payRequest(UserRequestDTO payRequestInfo) {
//		
//		SqlSession session = getSqlSession();
//		
//		int result = UserDAO.payRequest
//		
//		return null;
//	}

}
