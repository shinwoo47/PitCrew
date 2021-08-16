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

}
