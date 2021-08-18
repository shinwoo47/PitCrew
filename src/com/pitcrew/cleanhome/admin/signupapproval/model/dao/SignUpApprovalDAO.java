package com.pitcrew.cleanhome.admin.signupapproval.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.signupapproval.model.dto.SignUpApprovalDTO;

public class SignUpApprovalDAO {

	public int updateSignUpApproval(SqlSession session, SignUpApprovalDTO cleanerInfo) {
		return session.update("SignUpApprovalDAO.updateSignUpApproval", cleanerInfo);
	}

	public List<SignUpApprovalDTO> selectAllSignUpList(SqlSession session) {
		return session.selectList("SignUpApprovalDAO.selectAllSignUpList");
	}

}
