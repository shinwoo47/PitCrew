package com.pitcrew.cleanhome.cleaner.report.model.dto;

import java.io.Serializable;

public class ReportAttachmentDTO implements Serializable{

	private int reportAttachNo;
	private ReportDTO reportNo;
	private String originalName;
	private String savedName;
	private String savePath;
	private String thumbnailPath;
	private String attachCategory;
	
	public ReportAttachmentDTO() {}

	public ReportAttachmentDTO(int reportAttachNo, ReportDTO reportNo, String originalName, String savedName,
			String savePath, String thumbnailPath, String attachCategory) {
		super();
		this.reportAttachNo = reportAttachNo;
		this.reportNo = reportNo;
		this.originalName = originalName;
		this.savedName = savedName;
		this.savePath = savePath;
		this.thumbnailPath = thumbnailPath;
		this.attachCategory = attachCategory;
	}

	public int getReportAttachNo() {
		return reportAttachNo;
	}

	public void setReportAttachNo(int reportAttachNo) {
		this.reportAttachNo = reportAttachNo;
	}

	public ReportDTO getReportNo() {
		return reportNo;
	}

	public void setReportNo(ReportDTO reportNo) {
		this.reportNo = reportNo;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getSavedName() {
		return savedName;
	}

	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public String getAttachCategory() {
		return attachCategory;
	}

	public void setAttachCategory(String attachCategory) {
		this.attachCategory = attachCategory;
	}

	@Override
	public String toString() {
		return "ReportAttachmentDTO [reportAttachNo=" + reportAttachNo + ", reportNo=" + reportNo + ", originalName="
				+ originalName + ", savedName=" + savedName + ", savePath=" + savePath + ", thumbnailPath="
				+ thumbnailPath + ", attachCategory=" + attachCategory + "]";
	}
	
	
}
