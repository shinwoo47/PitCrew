package com.pitcrew.cleanhome.admin.blacklist.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.blacklist.model.dao.BlacklistDAO;
import com.pitcrew.cleanhome.admin.blacklist.model.dto.UserDTO;

public class BlacklistService {
	
	private final BlacklistDAO blacklistDAO;
	
	public BlacklistService() {
		blacklistDAO = new BlacklistDAO();
	}

	public List<UserDTO> selectAllBlacklist() {

		SqlSession session = getSqlSession();
		
		List<UserDTO> blacklistList = blacklistDAO.selectAllBlacklist(session);
		
		session.close();
		
		return blacklistList;
	}

	public int insertBlacklist(UserDTO newBlacklist) {

		SqlSession session = getSqlSession();
		
		int result = blacklistDAO.insertBlacklist(session, newBlacklist);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

	public int deleteBlacklist(int memNo) {

		SqlSession session = getSqlSession();
		
		int result = blacklistDAO.deleteBlacklist(session, memNo);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

}
