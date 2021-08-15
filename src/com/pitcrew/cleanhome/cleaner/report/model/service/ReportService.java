package com.pitcrew.cleanhome.cleaner.report.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.cleaner.report.model.dao.ReportDAO;
import com.pitcrew.cleanhome.cleaner.report.model.dto.ReportAttachmentDTO;
import com.pitcrew.cleanhome.cleaner.report.model.dto.ReportDTO;
import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;

public class ReportService {
	
	private ReportDAO reportDAO;
	
	public ReportService() {
		reportDAO = new ReportDAO();
	}

	public RequestDTO selectUserNo(int reqNo) {
		
		SqlSession session = getSqlSession();
		
		RequestDTO userNo = reportDAO.selectUserNo(session, reqNo); 
		
		session.close();
		
		return userNo;
	}

	public int insertReport(ReportDTO report, List<ReportAttachmentDTO> reportAttachmentList) {
		
		SqlSession session = getSqlSession();
		
		int result = reportDAO.insertReport(session, report);
		
		int reportNo = reportDAO.selectReportNo(session, report);
				
		int attachmentResult = 0;
		for(int i = 0; i < reportAttachmentList.size(); i++) {
			reportAttachmentList.get(i).setReportNo(reportNo);
			attachmentResult += reportDAO.insertAttachment(session, reportAttachmentList.get(i));
		}
		
		/* 모든 결과가 성공이면 트랜젝션을 완료한다. */
		if(result > 0 && attachmentResult == reportAttachmentList.size()) {
			session.commit();
			result = 1;
		} else {
			session.rollback();
		}
		
		return result;
	}

}
