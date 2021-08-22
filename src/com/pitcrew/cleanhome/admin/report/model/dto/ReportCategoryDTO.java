package com.pitcrew.cleanhome.admin.report.model.dto;

public class ReportCategoryDTO {
	
	private int reportCategoryCode;
	private String reportCategoryClass;
	private String reportCategoryName;
	private String reportCategoryYn;

	public ReportCategoryDTO() {}

	public ReportCategoryDTO(int reportCategoryCode, String reportCategoryClass, String reportCategoryName,
			String reportCategoryYn) {
		super();
		this.reportCategoryCode = reportCategoryCode;
		this.reportCategoryClass = reportCategoryClass;
		this.reportCategoryName = reportCategoryName;
		this.reportCategoryYn = reportCategoryYn;
	}

	public int getReportCategoryCode() {
		return reportCategoryCode;
	}

	public void setReportCategoryCode(int reportCategoryCode) {
		this.reportCategoryCode = reportCategoryCode;
	}

	public String getReportCategoryClass() {
		return reportCategoryClass;
	}

	public void setReportCategoryClass(String reportCategoryClass) {
		this.reportCategoryClass = reportCategoryClass;
	}

	public String getReportCategoryName() {
		return reportCategoryName;
	}

	public void setReportCategoryName(String reportCategoryName) {
		this.reportCategoryName = reportCategoryName;
	}

	public String getReportCategoryYn() {
		return reportCategoryYn;
	}

	public void setReportCategoryYn(String reportCategoryYn) {
		this.reportCategoryYn = reportCategoryYn;
	}

	@Override
	public String toString() {
		return "ReportCategoryDTO [reportCategoryCode=" + reportCategoryCode + ", reportCategoryClass="
				+ reportCategoryClass + ", reportCategoryName=" + reportCategoryName + ", reportCategoryYn="
				+ reportCategoryYn + "]";
	}
	
	
}

