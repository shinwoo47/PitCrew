package com.pitcrew.cleanhome.admin.calculator.model.dto;

import java.sql.Date;

import com.pitcrew.cleanhome.admin.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.admin.pay.model.dto.PayDTO;

public class CalSettingDTO {
	private MemberDTO cleaner;
	private int reqNo;
	private java.sql.Date reqDate;
	private PayDTO pay;
	private int cleanerPrice;
	
	public CalSettingDTO() {}

	public CalSettingDTO(MemberDTO cleaner, int reqNo, Date reqDate, PayDTO pay, int cleanerPrice) {
		super();
		this.cleaner = cleaner;
		this.reqNo = reqNo;
		this.reqDate = reqDate;
		this.pay = pay;
		this.cleanerPrice = cleanerPrice;
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

	public int getCleanerPrice() {
		return cleanerPrice;
	}

	public void setCleanerPrice(int cleanerPrice) {
		this.cleanerPrice = cleanerPrice;
	}

	@Override
	public String toString() {
		return "CalSettingDTO [cleaner=" + cleaner + ", reqNo=" + reqNo + ", reqDate=" + reqDate + ", pay=" + pay
				+ ", cleanerPrice=" + cleanerPrice + "]";
	}

	
	
	
}
