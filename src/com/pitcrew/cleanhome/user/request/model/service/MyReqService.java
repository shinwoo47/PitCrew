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
	
	/*한 회원의 모든 의뢰 정보를 조회하는 메소드*/
	public List<UserRequestDTO> selectMyAllReq(int memNoUser) {
		
		SqlSession session = getSqlSession();
		
		/* DAO에 세션과 회원 번호를 넘겨주고 의뢰 정보를 조회 */
		List<UserRequestDTO> selectMyAllReq = userReqDAO.selectMyAllReq(session, memNoUser);
		
		/* 세션 닫아준다. */
		session.close();
		
		return selectMyAllReq;
	}
	
	/*한 회원의 등록된 의뢰 정보*/
	public List<UserRequestDTO> myRegistRequest(int memNoUser) {

		SqlSession session = getSqlSession();
		
		List<UserRequestDTO> myRegistRequest = userReqDAO.myRegistRequest(session, memNoUser);
		
		session.close();
		
		return myRegistRequest;
	
	}

	/*한 회원의 매칭된 정보*/
	public List<UserRequestDTO> compRegistReq(int memNoUser) {
		
		SqlSession session = getSqlSession();
		
		List<UserRequestDTO> compRegistReq = userReqDAO.compRegistReq(session, memNoUser);
		
		session.close();
		
		return compRegistReq;
	}
	
	/*한 회원의 종료된 정보*/
	public List<UserRequestDTO> myeEndRequest(int memNoUser) {
	
		SqlSession session = getSqlSession();
		
		List<UserRequestDTO> myeEndRequest = userReqDAO.myeEndRequest(session, memNoUser);
		
		session.close();
		
		return myeEndRequest;
	}
	
	/* 의뢰 상세보기를 조회하기 위한 메소드 */
	public UserRequestDTO selectRequestDetail(UserRequestDTO userRequestDTO) {
		
		SqlSession session = getSqlSession();
		
		/* DAO에 세션과 회원 번호를 넘겨주고 의뢰 상세정보를 조회한다. */
		UserRequestDTO requestDetail = userReqDAO.selectRequestDetail(session, userRequestDTO);
		
		/* 세션을 닫아준다. */
		session.close();
		
		return requestDetail;
	}

}
