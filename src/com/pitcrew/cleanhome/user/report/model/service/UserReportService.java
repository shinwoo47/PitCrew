package com.pitcrew.cleanhome.user.report.model.service;

import com.pitcrew.cleanhome.cleaner.report.model.dto.ReportAttachmentDTO;
import com.pitcrew.cleanhome.cleaner.report.model.dto.ReportDTO;
import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.user.report.model.dao.UserReportDAO;
import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class UserReportService {
	
	private UserReportDAO userReportDAO;
	
	public UserReportService() {
		userReportDAO = new UserReportDAO();
	}
	
	/* 신고할 의뢰 번호 조회를 한다.*/
	public RequestDTO selectCleanerNo(int reqNo) {

		SqlSession session = getSqlSession();
		
		RequestDTO cleanerNo = userReportDAO.selectCleanerNo(session, reqNo);
		
		session.close();
		
		return cleanerNo;
	}
	
	/* 폼 데이터와 파일데이터를 insert하기 위한 메소드 */
	public int insertReport(ReportDTO report, List<ReportAttachmentDTO> reportAttachmentList) {
		
		SqlSession session = getSqlSession();
		
		int result = userReportDAO.insertReport(session, report);
		
		int attachmentResult = 0;
		for(int i = 0; i < reportAttachmentList.size(); i++) {
			attachmentResult += userReportDAO.insertAttachment(session, reportAttachmentList.get(i));
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
