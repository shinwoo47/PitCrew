package com.pitcrew.cleanhome.cleaner.calcalate.model.dto;

import java.util.Date;

public class CalculateDTO {
	
	private int calNo;
	private int memNo;
	private int calPrice;
	private int calTransferPrice;
	private Date calDate;
	private int incomeTax;
	private int residentTax;
	
	private String accountHolder;
	private String bankName;
	private String accountNo;
	
	public CalculateDTO() {}

	public CalculateDTO(int calNo, int memNo, int calPrice, int calTransferPrice, Date calDate, int incomeTax,
			int residentTax, String accountHolder, String bankName, String accountNo) {
		super();
		this.calNo = calNo;
		this.memNo = memNo;
		this.calPrice = calPrice;
		this.calTransferPrice = calTransferPrice;
		this.calDate = calDate;
		this.incomeTax = incomeTax;
		this.residentTax = residentTax;
		this.accountHolder = accountHolder;
		this.bankName = bankName;
		this.accountNo = accountNo;
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

	public Date getCalDate() {
		return calDate;
	}

	public void setCalDate(Date calDate) {
		this.calDate = calDate;
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

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "CalculateDTO [calNo=" + calNo + ", memNo=" + memNo + ", calPrice=" + calPrice + ", calTransferPrice="
				+ calTransferPrice + ", calDate=" + calDate + ", incomeTax=" + incomeTax + ", residentTax="
				+ residentTax + ", accountHolder=" + accountHolder + ", bankName=" + bankName + ", accountNo="
				+ accountNo + "]";
	}
	
	
	
}
