package com.pitcrew.cleanhome.admin.cleaner.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.cleaner.model.dto.CleanerDTO;

public class CleanerDAO {

	public List<CleanerDTO> selectAllCleanerInfoList(SqlSession session) {
		return session.selectList("CleanerDAO.selectAllCleanerInfoList");
	}

	public List<CleanerDTO> searchCleanerInfomation(SqlSession session, String categoryType, String searchResult) {
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("categoryType", categoryType);
		searchMap.put("searchResult", searchResult);
		
		return session.selectList("CleanerDAO.searchCleanerInfomation", searchMap);
	}

}
