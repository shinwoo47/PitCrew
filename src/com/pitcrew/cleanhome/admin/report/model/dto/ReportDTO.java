package com.pitcrew.cleanhome.admin.report.model.dto;

import com.pitcrew.cleanhome.admin.user.model.dto.UserDTO;

public class ReportDTO {
	
	private int reportNo;
	private String reportBody;
	private int memNoReporter;
	private int memNoSuspect;
	private int reportCategoryCode;
	private String penaltyCategoryCode;
	private int reqNo;
	private UserDTO memberRole;
	private UserDTO memId;
	private UserDTO memName;
	private UserDTO phone;
	private int penaltyScoreSum;
	
	
	public ReportDTO() {}


	public ReportDTO(int reportNo, String reportBody, int memNoReporter, int memNoSuspect, int reportCategoryCode,
			String penaltyCategoryCode, int reqNo, UserDTO memberRole, UserDTO memId, UserDTO memName, UserDTO phone,
			int penaltyScoreSum) {
		super();
		this.reportNo = reportNo;
		this.reportBody = reportBody;
		this.memNoReporter = memNoReporter;
		this.memNoSuspect = memNoSuspect;
		this.reportCategoryCode = reportCategoryCode;
		this.penaltyCategoryCode = penaltyCategoryCode;
		this.reqNo = reqNo;
		this.memberRole = memberRole;
		this.memId = memId;
		this.memName = memName;
		this.phone = phone;
		this.penaltyScoreSum = penaltyScoreSum;
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


	public int getMemNoSuspect() {
		return memNoSuspect;
	}


	public void setMemNoSuspect(int memNoSuspect) {
		this.memNoSuspect = memNoSuspect;
	}


	public int getReportCategoryCode() {
		return reportCategoryCode;
	}


	public void setReportCategoryCode(int reportCategoryCode) {
		this.reportCategoryCode = reportCategoryCode;
	}


	public String getPenaltyCategoryCode() {
		return penaltyCategoryCode;
	}


	public void setPenaltyCategoryCode(String penaltyCategoryCode) {
		this.penaltyCategoryCode = penaltyCategoryCode;
	}


	public int getReqNo() {
		return reqNo;
	}


	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}


	public UserDTO getMemberRole() {
		return memberRole;
	}


	public void setMemberRole(UserDTO memberRole) {
		this.memberRole = memberRole;
	}


	public UserDTO getMemId() {
		return memId;
	}


	public void setMemId(UserDTO memId) {
		this.memId = memId;
	}


	public UserDTO getMemName() {
		return memName;
	}


	public void setMemName(UserDTO memName) {
		this.memName = memName;
	}


	public UserDTO getPhone() {
		return phone;
	}


	public void setPhone(UserDTO phone) {
		this.phone = phone;
	}


	public int getPenaltyScoreSum() {
		return penaltyScoreSum;
	}


	public void setPenaltyScoreSum(int penaltyScoreSum) {
		this.penaltyScoreSum = penaltyScoreSum;
	}


	@Override
	public String toString() {
		return "ReportDTO [reportNo=" + reportNo + ", reportBody=" + reportBody + ", memNoReporter=" + memNoReporter
				+ ", memNoSuspect=" + memNoSuspect + ", reportCategoryCode=" + reportCategoryCode
				+ ", penaltyCategoryCode=" + penaltyCategoryCode + ", reqNo=" + reqNo + ", memberRole=" + memberRole
				+ ", memId=" + memId + ", memName=" + memName + ", phone=" + phone + ", penaltyScoreSum="
				+ penaltyScoreSum + "]";
	}

	
}
