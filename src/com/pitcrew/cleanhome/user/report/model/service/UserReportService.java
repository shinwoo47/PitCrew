package com.pitcrew.cleanhome.user.report.model.service;

import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.user.report.model.dao.UserReportDAO;
import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

public class UserReportService {
	
	private UserReportDAO userReportDAO;
	
	public UserReportService() {
		userReportDAO = new UserReportDAO();
	}

	public RequestDTO selectCleanerNo(int reqNo) {

		SqlSession session = getSqlSession();
		
		RequestDTO cleanerNo = userReportDAO.selectCleanerNo(session, reqNo);
		
		session.close();
		
		return cleanerNo;
	}

}
