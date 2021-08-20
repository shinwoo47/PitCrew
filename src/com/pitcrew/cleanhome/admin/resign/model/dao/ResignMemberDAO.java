package com.pitcrew.cleanhome.admin.resign.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.user.model.dto.UserDTO;

public class ResignMemberDAO {

	public List<UserDTO> selectAllResignMember(SqlSession session) {

		return session.selectList("ResignMemberDAO.selectAllResignMember");
	}

}
