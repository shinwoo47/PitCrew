package com.pitcrew.cleanhome.admin.user.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.user.model.dao.UserDAO;
import com.pitcrew.cleanhome.admin.user.model.dto.UserDTO;

public class UserService {

	private final UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	/* 사용자 정보 조회 */
	public List<UserDTO> selectAllUserInfoList() {
	
		SqlSession session = getSqlSession();

		List<UserDTO> userList = userDAO.selectAllUserInfoList(session);
		
		session.close();
		
		return userList;
		
	}
	
	public List<UserDTO> searchUserInfomation(String categoryType, String searchResult, Date enRollStartDate, Date enRollEndDate) {
	
		SqlSession session = getSqlSession();
	
		List<UserDTO> userList = userDAO.searchUserInfomation(session, categoryType, searchResult, enRollStartDate, enRollEndDate);

		session.close();
		
		return userList;
		
	}


}
