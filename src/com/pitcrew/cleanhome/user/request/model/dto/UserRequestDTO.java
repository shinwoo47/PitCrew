package com.pitcrew.cleanhome.user.request.model.dto;

import java.sql.Date;
import java.util.List;

import com.pitcrew.cleanhome.cleaner.report.model.dto.ReportDTO;
import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestAttachmentDTO;
import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestStatusDTO;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;


public class UserRequestDTO implements java.io.Serializable {
	
	/* 한 회원의 의뢰 정보가 담긴 DTO*/
	
	private int reqNo;
	private Date reqDate;
	private String reqReq;
	private int memNoUser;
	private int memNoCleaner;
	private String reqStatus;
	private MemberDTO role;
	private MemberDTO memName;
	private MemberDTO phone;
	private MemberDTO address;
	private List<RequestAttachmentDTO> requestAttachmentList;
	private List<ProductInfoDTO> productList;
	private List<RequestStatusDTO> requestStatusList;
	private List<ReportDTO> reportList;
	
	public UserRequestDTO () {}

	public UserRequestDTO(int reqNo, Date reqDate, String reqReq, int memNoUser, int memNoCleaner, String reqStatus,
			MemberDTO role, MemberDTO memName, MemberDTO phone, MemberDTO address,
			List<RequestAttachmentDTO> requestAttachmentList, List<ProductInfoDTO> productList,
			List<RequestStatusDTO> requestStatusList, List<ReportDTO> reportList) {
		super();
		this.reqNo = reqNo;
		this.reqDate = reqDate;
		this.reqReq = reqReq;
		this.memNoUser = memNoUser;
		this.memNoCleaner = memNoCleaner;
		this.reqStatus = reqStatus;
		this.role = role;
		this.memName = memName;
		this.phone = phone;
		this.address = address;
		this.requestAttachmentList = requestAttachmentList;
		this.productList = productList;
		this.requestStatusList = requestStatusList;
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

	public int getMemNoUser() {
		return memNoUser;
	}

	public void setMemNoUser(int memNoUser) {
		this.memNoUser = memNoUser;
	}

	public int getMemNoCleaner() {
		return memNoCleaner;
	}

	public void setMemNoCleaner(int memNoCleaner) {
		this.memNoCleaner = memNoCleaner;
	}

	public String getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
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

	public MemberDTO getPhone() {
		return phone;
	}

	public void setPhone(MemberDTO phone) {
		this.phone = phone;
	}

	public MemberDTO getAddress() {
		return address;
	}

	public void setAddress(MemberDTO address) {
		this.address = address;
	}

	public List<RequestAttachmentDTO> getRequestAttachmentList() {
		return requestAttachmentList;
	}

	public void setRequestAttachmentList(List<RequestAttachmentDTO> requestAttachmentList) {
		this.requestAttachmentList = requestAttachmentList;
	}

	public List<ProductInfoDTO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductInfoDTO> productList) {
		this.productList = productList;
	}

	public List<RequestStatusDTO> getRequestStatusList() {
		return requestStatusList;
	}

	public void setRequestStatusList(List<RequestStatusDTO> requestStatusList) {
		this.requestStatusList = requestStatusList;
	}

	public List<ReportDTO> getReportList() {
		return reportList;
	}

	public void setReportList(List<ReportDTO> reportList) {
		this.reportList = reportList;
	}

	@Override
	public String toString() {
		return "UserRequestDTO [reqNo=" + reqNo + ", reqDate=" + reqDate + ", reqReq=" + reqReq + ", memNoUser="
				+ memNoUser + ", memNoCleaner=" + memNoCleaner + ", reqStatus=" + reqStatus + ", role=" + role
				+ ", memName=" + memName + ", phone=" + phone + ", address=" + address + ", requestAttachmentList="
				+ requestAttachmentList + ", productList=" + productList + ", requestStatusList=" + requestStatusList
				+ ", reportList=" + reportList + "]";
	}

	
}
