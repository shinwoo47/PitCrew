package com.pitcrew.cleanhome.cleaner.report.model.dto;

import java.util.List;

import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;

public class ReportDTO {

	private int reportNo;
	private String reportBody;
	private MemberDTO memNoReporter;
	private MemberDTO memNoSucpect;
	private ReportCategoryDTO reportCategoryCode;
	private PenaltyDTO penaltyCategoryCode;
	private RequestDTO reqNo;
	private List<ReportAttachmentDTO> reportAttachmentList;
	
	public ReportDTO() {}

	public ReportDTO(int reportNo, String reportBody, MemberDTO memNoReporter, MemberDTO memNoSucpect,
			ReportCategoryDTO reportCategoryCode, PenaltyDTO penaltyCategoryCode, RequestDTO reqNo,
			List<ReportAttachmentDTO> reportAttachmentList) {
		super();
		this.reportNo = reportNo;
		this.reportBody = reportBody;
		this.memNoReporter = memNoReporter;
		this.memNoSucpect = memNoSucpect;
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

	public MemberDTO getMemNoReporter() {
		return memNoReporter;
	}

	public void setMemNoReporter(MemberDTO memNoReporter) {
		this.memNoReporter = memNoReporter;
	}

	public MemberDTO getMemNoSucpect() {
		return memNoSucpect;
	}

	public void setMemNoSucpect(MemberDTO memNoSucpect) {
		this.memNoSucpect = memNoSucpect;
	}

	public ReportCategoryDTO getReportCategoryCode() {
		return reportCategoryCode;
	}

	public void setReportCategoryCode(ReportCategoryDTO reportCategoryCode) {
		this.reportCategoryCode = reportCategoryCode;
	}

	public PenaltyDTO getPenaltyCategoryCode() {
		return penaltyCategoryCode;
	}

	public void setPenaltyCategoryCode(PenaltyDTO penaltyCategoryCode) {
		this.penaltyCategoryCode = penaltyCategoryCode;
	}

	public RequestDTO getReqNo() {
		return reqNo;
	}

	public void setReqNo(RequestDTO reqNo) {
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
				+ ", memNoSucpect=" + memNoSucpect + ", reqNo=" + reqNo + "]";
	}
	
	
}
