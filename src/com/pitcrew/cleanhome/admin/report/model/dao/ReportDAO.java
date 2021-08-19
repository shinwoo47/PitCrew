package com.pitcrew.cleanhome.admin.report.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.report.model.dto.ReportDTO;

public class ReportDAO {

	public List<ReportDTO> selectAllReportList(SqlSession session) {

		return session.selectList("ReportDAO.selectAllReportList");
	}

	public ReportDTO selectReportDetail(SqlSession session, int reportNo) {

		return session.selectOne("ReportDAO.selectReportDetail", reportNo);
	}

}
