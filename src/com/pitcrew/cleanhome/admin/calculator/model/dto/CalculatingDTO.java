package com.pitcrew.cleanhome.admin.calculator.model.dto;

import java.io.Serializable;
import java.sql.Date;

import com.pitcrew.cleanhome.admin.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;

public class CalculatingDTO implements Serializable{
	
	private int calNo;
	private MemberDTO cleaner;
	private int cleanerTransferPrice;
	private int incometax;
	private int residenttax;
	private java.sql.Date calDate;
	private RequestDTO request;
	
	
	public CalculatingDTO() {}


	public CalculatingDTO(int calNo, MemberDTO cleaner, int cleanerTransferPrice, int incometax,
			int residenttax, Date calDate, RequestDTO request) {
		super();
		this.calNo = calNo;
		this.cleaner = cleaner;
		this.cleanerTransferPrice = cleanerTransferPrice;
		this.incometax = incometax;
		this.residenttax = residenttax;
		this.calDate = calDate;
		this.request = request;
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


	public RequestDTO getRequest() {
		return request;
	}


	public void setRequest(RequestDTO request) {
		this.request = request;
	}


	@Override
	public String toString() {
		return "CalculatingDTO [calNo=" + calNo + ", cleaner=" + cleaner + ", cleanerTransferPrice=" 
				+ cleanerTransferPrice + ", incometax=" + incometax + ", residenttax="
				+ residenttax + ", calDate=" + calDate + ", request=" + request + "]";
	}

	
}
