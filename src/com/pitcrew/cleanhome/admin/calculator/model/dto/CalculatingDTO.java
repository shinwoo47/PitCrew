package com.pitcrew.cleanhome.admin.calculator.model.dto;

import java.io.Serializable;
import java.sql.Date;

import com.pitcrew.cleanhome.admin.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;

public class CalculatingDTO implements Serializable{
	
	private int calNo;
	private int memNo;
	private int calPrice;
	private int calTransferPrice;
	private java.sql.Date calDate;
	
	public CalculatingDTO() {}

	public CalculatingDTO(int calNo, int memNo, int calPrice, int calTransferPrice, Date calDate) {
		super();
		this.calNo = calNo;
		this.memNo = memNo;
		this.calPrice = calPrice;
		this.calTransferPrice = calTransferPrice;
		this.calDate = calDate;
	}

	public int getCalNo() {
		return calNo;
	}

	public void setCalNo(int calNo) {
		this.calNo = calNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getCalPrice() {
		return calPrice;
	}

	public void setCalPrice(int calPrice) {
		this.calPrice = calPrice;
	}

	public int getCalTransferPrice() {
		return calTransferPrice;
	}

	public void setCalTransferPrice(int calTransferPrice) {
		this.calTransferPrice = calTransferPrice;
	}

	public java.sql.Date getCalDate() {
		return calDate;
	}

	public void setCalDate(java.sql.Date calDate) {
		this.calDate = calDate;
	}

	@Override
	public String toString() {
		return "CalculatingDTO [calNo=" + calNo + ", memNo=" + memNo + ", calPrice=" + calPrice + ", calTransferPrice="
				+ calTransferPrice + ", calDate=" + calDate + "]";
	}

	
	
}
