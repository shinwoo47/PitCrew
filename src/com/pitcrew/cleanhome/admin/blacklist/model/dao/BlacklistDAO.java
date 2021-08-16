package com.pitcrew.cleanhome.admin.blacklist.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.blacklist.model.dto.UserDTO;

public class BlacklistDAO {

	public List<UserDTO> selectAllBlacklist(SqlSession session) {	
		return session.selectList("BlacklistDAO.selectAllBlacklist");
	}

}
