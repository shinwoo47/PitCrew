package com.pitcrew.cleanhome.cleaner.calculate.model.dto;

import java.util.Date;

public class CalculateByRequestDTO {

	private int reqNo;
	private Date reqDate;
	private int cleanerIncome;
	private int incomeTax;
	private int residentTax;
	private int transferPrice;
	private Date calDate;
	
	public CalculateByRequestDTO() {}

	public CalculateByRequestDTO(int reqNo, Date reqDate, int cleanerIncome, int incomeTax, int residentTax,
			int transferPrice, Date calDate) {
		super();
		this.reqNo = reqNo;
		this.reqDate = reqDate;
		this.cleanerIncome = cleanerIncome;
		this.incomeTax = incomeTax;
		this.residentTax = residentTax;
		this.transferPrice = transferPrice;
		this.calDate = calDate;
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

	public int getCleanerIncome() {
		return cleanerIncome;
	}

	public void setCleanerIncome(int cleanerIncome) {
		this.cleanerIncome = cleanerIncome;
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

	public Date getCalDate() {
		return calDate;
	}

	public void setCalDate(Date calDate) {
		this.calDate = calDate;
	}

	@Override
	public String toString() {
		return "CalculateByRequestDTO [reqNo=" + reqNo + ", reqDate=" + reqDate + ", cleanerIncome=" + cleanerIncome
				+ ", incomeTax=" + incomeTax + ", residentTax=" + residentTax + ", transferPrice=" + transferPrice
				+ ", calDate=" + calDate + "]";
	}

	
}
