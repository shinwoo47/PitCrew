package com.pitcrew.cleanhome.admin.user.model.dto;

import java.sql.Date;

import com.pitcrew.cleanhome.admin.pay.model.dto.PayListDTO;

public class UserDTO {
	
	private int memNo;
	private String memName;
	private String memId;
	private String email;
	private java.sql.Date birth;
	private String address;
	private String memPwd;
	private String phone;
	private java.sql.Date enrollDate;
	private String memberRole;
	private String entYn;
	private java.sql.Date entDate;
	private PayListDTO reqDate;
	private PayListDTO reqNo;
	
	public UserDTO() {}

	public UserDTO(int memNo, String memName, String memId, String email, Date birth, String address, String memPwd,
			String phone, Date enrollDate, String memberRole, String entYn, Date entDate, PayListDTO reqDate,
			PayListDTO reqNo) {
		super();
		this.memNo = memNo;
		this.memName = memName;
		this.memId = memId;
		this.email = email;
		this.birth = birth;
		this.address = address;
		this.memPwd = memPwd;
		this.phone = phone;
		this.enrollDate = enrollDate;
		this.memberRole = memberRole;
		this.entYn = entYn;
		this.entDate = entDate;
		this.reqDate = reqDate;
		this.reqNo = reqNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.sql.Date getBirth() {
		return birth;
	}

	public void setBirth(java.sql.Date birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public java.sql.Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(java.sql.Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}

	public String getEntYn() {
		return entYn;
	}

	public void setEntYn(String entYn) {
		this.entYn = entYn;
	}

	public java.sql.Date getEntDate() {
		return entDate;
	}

	public void setEntDate(java.sql.Date entDate) {
		this.entDate = entDate;
	}

	public PayListDTO getReqDate() {
		return reqDate;
	}

	public void setReqDate(PayListDTO reqDate) {
		this.reqDate = reqDate;
	}

	public PayListDTO getReqNo() {
		return reqNo;
	}

	public void setReqNo(PayListDTO reqNo) {
		this.reqNo = reqNo;
	}

	@Override
	public String toString() {
		return "UserDTO [memNo=" + memNo + ", memName=" + memName + ", memId=" + memId + ", email=" + email + ", birth="
				+ birth + ", address=" + address + ", memPwd=" + memPwd + ", phone=" + phone + ", enrollDate="
				+ enrollDate + ", memberRole=" + memberRole + ", entYn=" + entYn + ", entDate=" + entDate + ", reqDate="
				+ reqDate + ", reqNo=" + reqNo + "]";
	}

	
	
}


