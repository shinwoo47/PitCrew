package com.pitcrew.cleanhome.user.request.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.user.model.dto.CleanDTO;
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


	public List<UserRequestDTO> compRegistReq(int memNoUser) {
		
		SqlSession session = getSqlSession();
		
		List<UserRequestDTO> compRegistReq = userReqDAO.compRegistReq(session, memNoUser);
		
		session.close();
		
		return compRegistReq;
	}

	
	
	public UserRequestDTO selectRequestDetail(UserRequestDTO userRequestDTO) {
		
		SqlSession session = getSqlSession();
		
		String status = userReqDAO.selectRequestStatus(session, userRequestDTO);
		userRequestDTO.setReqStatus(status);
		
		UserRequestDTO requestDetail = userReqDAO.selectRequestDetail(session, userRequestDTO);
		
		return requestDetail;
	}


	public int payRequest(CleanDTO payReqInfo) {

		SqlSession session = getSqlSession();
		
		int result = userReqDAO.payRequestInfo(session, payReqInfo);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}


}
