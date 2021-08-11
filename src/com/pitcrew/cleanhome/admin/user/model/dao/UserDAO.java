package com.pitcrew.cleanhome.admin.user.model.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.user.model.dto.UserDTO;

public class UserDAO {

	public List<UserDTO> selectAllUserInfoList(SqlSession session) {
		return session.selectList("UserDAO.selectAllUserInfoList");
		
	}

	public List<UserDTO> searchUserInfomation(SqlSession session, String categoryType, String searchResult, java.sql.Date enRollStartDate, java.sql.Date enRollEndDate) {
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("categoryType", categoryType);
		searchMap.put("searchResult", searchResult);
		searchMap.put("enRollStartDate", enRollStartDate);
		searchMap.put("enRollEndDate", enRollEndDate);
		System.out.println("송준일이이이이" + searchMap);
		
		return session.selectList("UserDAO.searchUserInfomation",searchMap);
		
	}
}
