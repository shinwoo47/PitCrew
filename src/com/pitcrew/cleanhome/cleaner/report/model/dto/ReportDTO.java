package com.pitcrew.cleanhome.cleaner.report.model.dto;

import java.util.List;

import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;

public class ReportDTO {

	private int reportNo;
	private String reportBody;
	private int memNoReporter;
	private int memNoSuspect;
	private int reportCategoryCode;
	private int penaltyCategoryCode;
	private int reqNo;
	private List<ReportAttachmentDTO> reportAttachmentList;
	
	public ReportDTO() {}

	public ReportDTO(int reportNo, String reportBody, int memNoReporter, int memNoSuspect, int reportCategoryCode,
			int penaltyCategoryCode, int reqNo, List<ReportAttachmentDTO> reportAttachmentList) {
		super();
		this.reportNo = reportNo;
		this.reportBody = reportBody;
		this.memNoReporter = memNoReporter;
		this.memNoSuspect = memNoSuspect;
		this.reportCategoryCode = reportCategoryCode;
		this.penaltyCategoryCode = penaltyCategoryCode;
		this.reqNo = reqNo;
		this.reportAttachmentList = reportAttachmentList;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public String getReportBody() {
		return reportBody;
	}

	public void setReportBody(String reportBody) {
		this.reportBody = reportBody;
	}

	public int getMemNoReporter() {
		return memNoReporter;
	}

	public void setMemNoReporter(int memNoReporter) {
		this.memNoReporter = memNoReporter;
	}

	public int getMemNoSucpect() {
		return memNoSuspect;
	}

	public void setMemNoSucpect(int memNoSucpect) {
		this.memNoSuspect = memNoSucpect;
	}

	public int getReportCategoryCode() {
		return reportCategoryCode;
	}

	public void setReportCategoryCode(int reportCategoryCode) {
		this.reportCategoryCode = reportCategoryCode;
	}

	public int getPenaltyCategoryCode() {
		return penaltyCategoryCode;
	}

	public void setPenaltyCategoryCode(int penaltyCategoryCode) {
		this.penaltyCategoryCode = penaltyCategoryCode;
	}

	public int getReqNo() {
		return reqNo;
	}

	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	public List<ReportAttachmentDTO> getReportAttachmentList() {
		return reportAttachmentList;
	}

	public void setReportAttachmentList(List<ReportAttachmentDTO> reportAttachmentList) {
		this.reportAttachmentList = reportAttachmentList;
	}

	@Override
	public String toString() {
		return "ReportDTO [reportNo=" + reportNo + ", reportBody=" + reportBody + ", memNoReporter=" + memNoReporter
				+ ", memNoSucpect=" + memNoSuspect + ", reportCategoryCode=" + reportCategoryCode
				+ ", penaltyCategoryCode=" + penaltyCategoryCode + ", reqNo=" + reqNo + ", reportAttachmentList="
				+ reportAttachmentList + "]";
	}

	
	
	
}
