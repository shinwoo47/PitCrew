package com.pitcrew.cleanhome.admin.user.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.user.model.dto.UserDTO;

public class UserDAO {

	public List<UserDTO> selectAllUserInfoList(SqlSession session) {
		return session.selectList("UserDAO.selectAllUserInfoList");
		
	}

}
