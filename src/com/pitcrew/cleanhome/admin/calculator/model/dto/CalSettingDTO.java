package com.pitcrew.cleanhome.admin.calculator.model.dto;

import java.sql.Date;

import com.pitcrew.cleanhome.admin.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.admin.pay.model.dto.PayDTO;

public class CalSettingDTO {
	private MemberDTO cleaner;
	private int reqNo;
	private java.sql.Date reqDate;
	private PayDTO pay;
	
	public CalSettingDTO() {}

	public CalSettingDTO(MemberDTO cleaner, int reqNo, Date reqDate, PayDTO pay) {
		super();
		this.cleaner = cleaner;
		this.reqNo = reqNo;
		this.reqDate = reqDate;
		this.pay = pay;
	}

	public MemberDTO getCleaner() {
		return cleaner;
	}

	public void setCleaner(MemberDTO cleaner) {
		this.cleaner = cleaner;
	}

	public int getReqNo() {
		return reqNo;
	}

	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	public java.sql.Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(java.sql.Date reqDate) {
		this.reqDate = reqDate;
	}

	public PayDTO getPay() {
		return pay;
	}

	public void setPay(PayDTO pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "CalSettingDTO [cleaner=" + cleaner + ", reqNo=" + reqNo + ", reqDate=" + reqDate + ", pay=" + pay + "]";
	}

	
	
}
