package com.pitcrew.cleanhome.user.report.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;

public class UserReportDAO {

	public RequestDTO selectCleanerNo(SqlSession session, int reqNo) {
		
		return session.selectOne("UserReportDAO.selectCleanerNo", reqNo);
	}

}
