package com.pitcrew.cleanhome.admin.calculator.model.dto;

import java.io.Serializable;
import java.sql.Date;

import com.pitcrew.cleanhome.admin.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;

public class CalculatingDTO implements Serializable{
	
	private int calNo;
	private MemberDTO cleaner;
	private int calPrice;
	private int transferPrice;
	private java.sql.Date calDate;
	private RequestDTO requestInfo;
	
	public CalculatingDTO() {}

	public CalculatingDTO(int calNo, MemberDTO cleaner, int calPrice, int transferPrice, Date calDate,
			RequestDTO requestInfo) {
		super();
		this.calNo = calNo;
		this.cleaner = cleaner;
		this.calPrice = calPrice;
		this.transferPrice = transferPrice;
		this.calDate = calDate;
		this.requestInfo = requestInfo;
	}

	public int getCalNo() {
		return calNo;
	}

	public void setCalNo(int calNo) {
		this.calNo = calNo;
	}

	public MemberDTO getCleaner() {
		return cleaner;
	}

	public void setCleaner(MemberDTO cleaner) {
		this.cleaner = cleaner;
	}

	public int getCalPrice() {
		return calPrice;
	}

	public void setCalPrice(int calPrice) {
		this.calPrice = calPrice;
	}

	public int getTransferPrice() {
		return transferPrice;
	}

	public void setTransferPrice(int transferPrice) {
		this.transferPrice = transferPrice;
	}

	public java.sql.Date getCalDate() {
		return calDate;
	}

	public void setCalDate(java.sql.Date calDate) {
		this.calDate = calDate;
	}

	public RequestDTO getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(RequestDTO requestInfo) {
		this.requestInfo = requestInfo;
	}

	@Override
	public String toString() {
		return "CalculatingDTO [calNo=" + calNo + ", cleaner=" + cleaner + ", calPrice=" + calPrice + ", transferPrice="
				+ transferPrice + ", calDate=" + calDate + ", requestInfo=" + requestInfo + "]";
	}
	
	
	
}
