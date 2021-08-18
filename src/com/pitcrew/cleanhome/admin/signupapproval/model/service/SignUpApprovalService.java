package com.pitcrew.cleanhome.admin.signupapproval.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.signupapproval.model.dao.SignUpApprovalDAO;
import com.pitcrew.cleanhome.admin.signupapproval.model.dto.SignUpApprovalDTO;
import com.pitcrew.cleanhome.member.model.dto.CleanerInfoDTO;

public class SignUpApprovalService {
	
	private final SignUpApprovalDAO signUpApprovalDAO;
	
	public SignUpApprovalService() {
		signUpApprovalDAO = new SignUpApprovalDAO();
	}
	

	public int SignUpApproval(SignUpApprovalDTO cleanerInfo) {

		SqlSession session = getSqlSession();
		
		int result = signUpApprovalDAO.updateSignUpApproval(session, cleanerInfo);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}


	public List<SignUpApprovalDTO> selectAllSignUpList() {
		
		SqlSession session = getSqlSession();
		
		List<SignUpApprovalDTO> signUpList = signUpApprovalDAO.selectAllSignUpList(session);
		
		session.close();
		
		return signUpList;
	}

}
