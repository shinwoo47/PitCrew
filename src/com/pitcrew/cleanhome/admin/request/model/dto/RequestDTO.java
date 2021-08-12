package com.pitcrew.cleanhome.admin.request.model.dto;

import java.sql.Date;
import java.util.List;

import com.pitcrew.cleanhome.admin.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.admin.product.model.dto.ProductInfoDTO;
import com.pitcrew.cleanhome.admin.product.model.dto.ProductReqDTO;

public class RequestDTO {
	
	private int reqNo;
	private java.sql.Date serviceDate;
	private String wantThing;
	private MemberDTO cleanerNo;
	private ReqInfoDTO reqDate;
	private MemberDTO userNo;
	private String status;
	private List<ProductInfoDTO> productName;
	
	public RequestDTO() {}

	public RequestDTO(int reqNo, Date serviceDate, String wantThing, MemberDTO cleanerNo, ReqInfoDTO reqDate,
			MemberDTO userNo, String status, List<ProductInfoDTO> productName) {
		super();
		this.reqNo = reqNo;
		this.serviceDate = serviceDate;
		this.wantThing = wantThing;
		this.cleanerNo = cleanerNo;
		this.reqDate = reqDate;
		this.userNo = userNo;
		this.status = status;
		this.productName = productName;
	}

	public int getReqNo() {
		return reqNo;
	}

	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	public java.sql.Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(java.sql.Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getWantThing() {
		return wantThing;
	}

	public void setWantThing(String wantThing) {
		this.wantThing = wantThing;
	}

	public MemberDTO getCleanerNo() {
		return cleanerNo;
	}

	public void setCleanerNo(MemberDTO cleanerNo) {
		this.cleanerNo = cleanerNo;
	}

	public ReqInfoDTO getReqDate() {
		return reqDate;
	}

	public void setReqDate(ReqInfoDTO reqDate) {
		this.reqDate = reqDate;
	}

	public MemberDTO getUserNo() {
		return userNo;
	}

	public void setUserNo(MemberDTO userNo) {
		this.userNo = userNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ProductInfoDTO> getProductName() {
		return productName;
	}

	public void setProductName(List<ProductInfoDTO> productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "RequestDTO [reqNo=" + reqNo + ", serviceDate=" + serviceDate + ", wantThing=" + wantThing
				+ ", cleanerNo=" + cleanerNo + ", reqDate=" + reqDate + ", userNo=" + userNo + ", status=" + status
				+ ", productName=" + productName + "]";
	}

	
	
	
}
