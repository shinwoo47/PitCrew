package com.pitcrew.cleanhome.admin.report.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.report.model.dao.ReportDAO;
import com.pitcrew.cleanhome.admin.report.model.dto.ReportDTO;


public class ReportService {
	private final ReportDAO reportDAO;
	
	public ReportService() {
		reportDAO = new ReportDAO();
	}
	

	public List<ReportDTO> selectAllReportList() {
		
		SqlSession session = getSqlSession();
		
		List<ReportDTO> reportList = reportDAO.selectAllReportList(session);
		
		session.close();
		
		return reportList;
	}

}
