package com.pitcrew.cleanhome.cleaner.report.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.cleaner.report.model.dto.ReportAttachmentDTO;
import com.pitcrew.cleanhome.cleaner.report.model.dto.ReportDTO;
import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;

public class ReportDAO {

	public RequestDTO selectUserNo(SqlSession session, int reqNo) {
		
		return session.selectOne("ReportDAO.selectUserNo", reqNo);
	}

	public int insertReport(SqlSession session, ReportDTO report) {
		
		return session.insert("ReportDAO.insertReport", report);
	}

	public int insertAttachment(SqlSession session, ReportAttachmentDTO reportAttachmentDTO) {
		
		return session.insert("ReportDAO.insertAttachment", reportAttachmentDTO);
	}

	public int selectReportNo(SqlSession session, ReportDTO report) {
		
		return session.selectOne("ReportDAO.selectReportNo", report);
	}

}
