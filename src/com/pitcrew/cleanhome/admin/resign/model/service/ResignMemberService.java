package com.pitcrew.cleanhome.admin.resign.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.resign.model.dao.ResignMemberDAO;
import com.pitcrew.cleanhome.admin.user.model.dto.UserDTO;

public class ResignMemberService {
	
	private final ResignMemberDAO resignMemberDAO;
	
	public ResignMemberService() {
		resignMemberDAO = new ResignMemberDAO();
	}

	public List<UserDTO> selectAllResignMember() {
		
		SqlSession session = getSqlSession();
		
		List<UserDTO> resignMemberList = resignMemberDAO.selectAllResignMember(session);
		
		session.close();
		
		return resignMemberList;
	}

}
