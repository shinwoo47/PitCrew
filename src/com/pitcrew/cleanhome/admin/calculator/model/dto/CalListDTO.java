package com.pitcrew.cleanhome.admin.calculator.model.dto;

import java.sql.Date;

public class CalListDTO {

	private int memNo;
	private String memId;
	private String memName;
	private java.sql.Date enrollDate;
	private java.sql.Date serviceDate;
	private java.sql.Date calDate;
	private int calcPrice;
	private int incomeTax;
	private int residentTax;
	private int transferPrice;
	private int reqNo;
	
	public CalListDTO() {}

	public CalListDTO(int memNo, String memId, String memName, Date enrollDate, Date serviceDate, Date calDate,
			int calcPrice, int incomeTax, int residentTax, int transferPrice, int reqNo) {
		super();
		this.memNo = memNo;
		this.memId = memId;
		this.memName = memName;
		this.enrollDate = enrollDate;
		this.serviceDate = serviceDate;
		this.calDate = calDate;
		this.calcPrice = calcPrice;
		this.incomeTax = incomeTax;
		this.residentTax = residentTax;
		this.transferPrice = transferPrice;
		this.reqNo = reqNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public java.sql.Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(java.sql.Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public java.sql.Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(java.sql.Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public java.sql.Date getCalDate() {
		return calDate;
	}

	public void setCalDate(java.sql.Date calDate) {
		this.calDate = calDate;
	}

	public int getCalcPrice() {
		return calcPrice;
	}

	public void setCalcPrice(int calcPrice) {
		this.calcPrice = calcPrice;
	}

	public int getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(int incomeTax) {
		this.incomeTax = incomeTax;
	}

	public int getResidentTax() {
		return residentTax;
	}

	public void setResidentTax(int residentTax) {
		this.residentTax = residentTax;
	}

	public int getTransferPrice() {
		return transferPrice;
	}

	public void setTransferPrice(int transferPrice) {
		this.transferPrice = transferPrice;
	}

	public int getReqNo() {
		return reqNo;
	}

	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	@Override
	public String toString() {
		return "CalListDTO [memNo=" + memNo + ", memId=" + memId + ", memName=" + memName + ", enrollDate=" + enrollDate
				+ ", serviceDate=" + serviceDate + ", calDate=" + calDate + ", calcPrice=" + calcPrice + ", incomeTax="
				+ incomeTax + ", residentTax=" + residentTax + ", transferPrice=" + transferPrice + ", reqNo=" + reqNo
				+ "]";
	}

	

	
	
	
	
}
