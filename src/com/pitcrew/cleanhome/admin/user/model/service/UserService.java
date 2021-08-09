package com.pitcrew.cleanhome.admin.user.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.user.model.dao.UserDAO;
import com.pitcrew.cleanhome.admin.user.model.dto.UserDTO;

public class UserService {

	private final UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	
	public List<UserDTO> selectAllUserInfoList() {

		SqlSession session = getSqlSession();
		
		List<UserDTO> userList = userDAO.selectAllUserInfoList(session);
		
		session.close();
		
		return userList;
		
	}

}
