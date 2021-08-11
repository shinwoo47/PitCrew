package com.pitcrew.cleanhome.cleaner.request.model.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.pitcrew.cleanhome.cleaner.report.model.dto.ReportDTO;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;

public class RequestDTO implements Serializable{

	private int reqNo;
	private Date reqDate;
	private String reqReq;
	private int memNoCleaner;
	private MemberDTO address;
	private MemberDTO role;
	private MemberDTO memName;
	private MemberDTO phone;
	private int memNoUser;
	private String reqStatus;
	private List<RequestAttachmentDTO> requestAttachmentList;
	private List<RequestStatusDTO> requestStatusList;
	private List<ProductDTO> productList;
	private List<ReportDTO> reportList;
	
	
	public RequestDTO() {}


	




	public RequestDTO(int reqNo, Date reqDate, String reqReq, int memNoCleaner, MemberDTO address, MemberDTO role,
			MemberDTO memName, MemberDTO phone, int memNoUser, String reqStatus,
			List<RequestAttachmentDTO> requestAttachmentList, List<RequestStatusDTO> requestStatusList,
			List<ProductDTO> productList, List<ReportDTO> reportList) {
		super();
		this.reqNo = reqNo;
		this.reqDate = reqDate;
		this.reqReq = reqReq;
		this.memNoCleaner = memNoCleaner;
		this.address = address;
		this.role = role;
		this.memName = memName;
		this.phone = phone;
		this.memNoUser = memNoUser;
		this.reqStatus = reqStatus;
		this.requestAttachmentList = requestAttachmentList;
		this.requestStatusList = requestStatusList;
		this.productList = productList;
		this.reportList = reportList;
	}







	public int getReqNo() {
		return reqNo;
	}





	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}





	public Date getReqDate() {
		return reqDate;
	}





	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}





	public String getReqReq() {
		return reqReq;
	}





	public void setReqReq(String reqReq) {
		this.reqReq = reqReq;
	}





	public int getMemNoCleaner() {
		return memNoCleaner;
	}





	public void setMemNoCleaner(int memNoCleaner) {
		this.memNoCleaner = memNoCleaner;
	}





	public MemberDTO getAddress() {
		return address;
	}





	public void setAddress(MemberDTO address) {
		this.address = address;
	}





	public MemberDTO getRole() {
		return role;
	}





	public void setRole(MemberDTO role) {
		this.role = role;
	}





	public MemberDTO getMemName() {
		return memName;
	}





	public void setMemName(MemberDTO memName) {
		this.memName = memName;
	}





	public int getMemNoUser() {
		return memNoUser;
	}





	public void setMemNoUser(int memNoUser) {
		this.memNoUser = memNoUser;
	}





	public String getReqStatus() {
		return reqStatus;
	}





	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}





	public List<RequestAttachmentDTO> getRequestAttachmentList() {
		return requestAttachmentList;
	}





	public void setRequestAttachmentList(List<RequestAttachmentDTO> requestAttachmentList) {
		this.requestAttachmentList = requestAttachmentList;
	}





	public List<RequestStatusDTO> getRequestStatusList() {
		return requestStatusList;
	}





	public void setRequestStatusList(List<RequestStatusDTO> requestStatusList) {
		this.requestStatusList = requestStatusList;
	}





	public List<ProductDTO> getProductList() {
		return productList;
	}





	public void setProductList(List<ProductDTO> productList) {
		this.productList = productList;
	}





	public List<ReportDTO> getReportList() {
		return reportList;
	}





	public void setReportList(List<ReportDTO> reportList) {
		this.reportList = reportList;
	}



	public MemberDTO getPhone() {
		return phone;
	}


	public void setPhone(MemberDTO phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "RequestDTO [reqNo=" + reqNo + ", reqDate=" + reqDate + ", reqReq=" + reqReq + ", memNoCleaner="
				+ memNoCleaner + ", address=" + address + ", role=" + role + ", memName=" + memName + ", phone=" + phone
				+ ", memNoUser=" + memNoUser + ", reqStatus=" + reqStatus + ", requestAttachmentList="
				+ requestAttachmentList + ", requestStatusList=" + requestStatusList + ", productList=" + productList
				+ ", reportList=" + reportList + "]";
	}

	
}
