package com.pitcrew.cleanhome.cleaner.request.model.dto;

import java.io.Serializable;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;

public class RequestAttachmentDTO implements Serializable{
	
	private int reqAttachNo;
	private String originalName;
	private String savedName;
	private String savePath;
	private String thumbnailPath;
	private String reqAttachCategory;
	private RequestDTO reqNo;
	
	public RequestAttachmentDTO() {}

	public RequestAttachmentDTO(int reqAttachNo, String originalName, String savedName, String savePath,
			String thumbnailPath, String reqAttachCategory, RequestDTO reqNo) {
		super();
		this.reqAttachNo = reqAttachNo;
		this.originalName = originalName;
		this.savedName = savedName;
		this.savePath = savePath;
		this.thumbnailPath = thumbnailPath;
		this.reqAttachCategory = reqAttachCategory;
		this.reqNo = reqNo;
	}

	public int getReqAttachNo() {
		return reqAttachNo;
	}

	public void setReqAttachNo(int reqAttachNo) {
		this.reqAttachNo = reqAttachNo;
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

	public String getReqAttachCategory() {
		return reqAttachCategory;
	}

	public void setReqAttachCategory(String reqAttachCategory) {
		this.reqAttachCategory = reqAttachCategory;
	}

	public RequestDTO getReqNo() {
		return reqNo;
	}

	public void setReqNo(RequestDTO reqNo) {
		this.reqNo = reqNo;
	}

	@Override
	public String toString() {
		return "RequestAttachmentDTO [reqAttachNo=" + reqAttachNo + ", originalName=" + originalName + ", savedName="
				+ savedName + ", savePath=" + savePath + ", thumbnailPath=" + thumbnailPath + ", reqAttachCategory="
				+ reqAttachCategory + ", reqNo=" + reqNo + "]";
	}
	
	
}
