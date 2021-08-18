package com.pitcrew.cleanhome.admin.calculator.model.dto;

import java.io.Serializable;
import java.sql.Date;

import com.pitcrew.cleanhome.admin.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;

public class CalculatingDTO implements Serializable{
	
	private int calNo;
	private int cleanerNo;
	private int cleanerIncome;
	private int cleanerTransferPrice;
	private int incometax;
	private int residenttax;
	private java.sql.Date calDate;
	private int reqNo;
	
	
	public CalculatingDTO() {}


	public CalculatingDTO(int calNo, int cleanerNo, int cleanerIncome, int cleanerTransferPrice, int incometax,
			int residenttax, Date calDate, int reqNo) {
		super();
		this.calNo = calNo;
		this.cleanerNo = cleanerNo;
		this.cleanerIncome = cleanerIncome;
		this.cleanerTransferPrice = cleanerTransferPrice;
		this.incometax = incometax;
		this.residenttax = residenttax;
		this.calDate = calDate;
		this.reqNo = reqNo;
	}


	public int getCalNo() {
		return calNo;
	}


	public void setCalNo(int calNo) {
		this.calNo = calNo;
	}


	public int getCleanerNo() {
		return cleanerNo;
	}


	public void setCleanerNo(int cleanerNo) {
		this.cleanerNo = cleanerNo;
	}


	public int getCleanerIncome() {
		return cleanerIncome;
	}


	public void setCleanerIncome(int cleanerIncome) {
		this.cleanerIncome = cleanerIncome;
	}


	public int getCleanerTransferPrice() {
		return cleanerTransferPrice;
	}


	public void setCleanerTransferPrice(int cleanerTransferPrice) {
		this.cleanerTransferPrice = cleanerTransferPrice;
	}


	public int getIncometax() {
		return incometax;
	}


	public void setIncometax(int incometax) {
		this.incometax = incometax;
	}


	public int getResidenttax() {
		return residenttax;
	}


	public void setResidenttax(int residenttax) {
		this.residenttax = residenttax;
	}


	public java.sql.Date getCalDate() {
		return calDate;
	}


	public void setCalDate(java.sql.Date calDate) {
		this.calDate = calDate;
	}


	public int getReqNo() {
		return reqNo;
	}


	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}


	@Override
	public String toString() {
		return "CalculatingDTO [calNo=" + calNo + ", cleanerNo=" + cleanerNo + ", cleanerIncome=" + cleanerIncome
				+ ", cleanerTransferPrice=" + cleanerTransferPrice + ", incometax=" + incometax + ", residenttax="
				+ residenttax + ", calDate=" + calDate + ", reqNo=" + reqNo + "]";
	}


	
}
