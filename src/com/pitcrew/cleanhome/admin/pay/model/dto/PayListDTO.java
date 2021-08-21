package com.pitcrew.cleanhome.admin.pay.model.dto;

import java.sql.Date;

import com.pitcrew.cleanhome.admin.user.model.dto.UserDTO;

public class PayListDTO {
	
	private UserDTO memNo;
	private UserDTO memId;
	private UserDTO memName;
	private int reqNo;
	private int payNo;
	private int payPrice;
	private Date payDate;
	private String payApprovalNo;
	private Date reqDate;
	
	public PayListDTO() {}

	public PayListDTO(UserDTO memNo, UserDTO memId, UserDTO memName, int reqNo, int payNo, int payPrice, Date payDate,
			String payApprovalNo, Date reqDate) {
		super();
		this.memNo = memNo;
		this.memId = memId;
		this.memName = memName;
		this.reqNo = reqNo;
		this.payNo = payNo;
		this.payPrice = payPrice;
		this.payDate = payDate;
		this.payApprovalNo = payApprovalNo;
		this.reqDate = reqDate;
	}

	public UserDTO getMemNo() {
		return memNo;
	}

	public void setMemNo(UserDTO memNo) {
		this.memNo = memNo;
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

	public int getReqNo() {
		return reqNo;
	}

	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	public int getPayNo() {
		return payNo;
	}

	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}

	public int getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public String getPayApprovalNo() {
		return payApprovalNo;
	}

	public void setPayApprovalNo(String payApprovalNo) {
		this.payApprovalNo = payApprovalNo;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	@Override
	public String toString() {
		return "PayListDTO [memNo=" + memNo + ", memId=" + memId + ", memName=" + memName + ", reqNo=" + reqNo
				+ ", payNo=" + payNo + ", payPrice=" + payPrice + ", payDate=" + payDate + ", payApprovalNo="
				+ payApprovalNo + ", reqDate=" + reqDate + "]";
	}

	
}


