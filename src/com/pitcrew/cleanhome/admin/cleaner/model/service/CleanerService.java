package com.pitcrew.cleanhome.admin.cleaner.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.cleaner.model.dao.CleanerDAO;
import com.pitcrew.cleanhome.admin.cleaner.model.dto.CleanerDTO;

public class CleanerService {
	
	private final CleanerDAO cleanerDAO;
	
	public CleanerService() {
		cleanerDAO = new CleanerDAO();
	}
	
	/* 해결사 정보 조회 */
	public List<CleanerDTO> selectAllCleanerInfoList() {

		SqlSession session = getSqlSession();
		
		List<CleanerDTO> cleanerList = cleanerDAO.selectAllCleanerInfoList(session);
		
		session.close();
		
		return cleanerList;
	}

	public List<CleanerDTO> searchCleanerInfomation(String categoryType, String searchResult) {

		SqlSession session = getSqlSession();
		
		List<CleanerDTO> cleanerList = cleanerDAO.searchCleanerInfomation(session, categoryType, searchResult);
		
		session.close();
		
		return cleanerList;
	}

}












