package com.pitcrew.cleanhome.admin.cleaner.model.dto;

import java.sql.Date;

public class CleanerInfoDTO {
	
	private int memNo;
	private String identifyYn;
	private String eduateYn;
	private java.sql.Date identifyDate;
	private java.sql.Date educateDate;
	private String accountNo;
	private String bankname;
	private String accountHolder;
	
	public CleanerInfoDTO() {}

	public CleanerInfoDTO(int memNo, String identifyYn, String eduateYn, Date identifyDate, Date educateDate,
			String accountNo, String bankname, String accountHolder) {
		super();
		this.memNo = memNo;
		this.identifyYn = identifyYn;
		this.eduateYn = eduateYn;
		this.identifyDate = identifyDate;
		this.educateDate = educateDate;
		this.accountNo = accountNo;
		this.bankname = bankname;
		this.accountHolder = accountHolder;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getIdentifyYn() {
		return identifyYn;
	}

	public void setIdentifyYn(String identifyYn) {
		this.identifyYn = identifyYn;
	}

	public String getEduateYn() {
		return eduateYn;
	}

	public void setEduateYn(String eduateYn) {
		this.eduateYn = eduateYn;
	}

	public java.sql.Date getIdentifyDate() {
		return identifyDate;
	}

	public void setIdentifyDate(java.sql.Date identifyDate) {
		this.identifyDate = identifyDate;
	}

	public java.sql.Date getEducateDate() {
		return educateDate;
	}

	public void setEducateDate(java.sql.Date educateDate) {
		this.educateDate = educateDate;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	@Override
	public String toString() {
		return "CleanerInfoDTO [memNo=" + memNo + ", identifyYn=" + identifyYn + ", eduateYn=" + eduateYn
				+ ", identifyDate=" + identifyDate + ", educateDate=" + educateDate + ", accountNo=" + accountNo
				+ ", bankname=" + bankname + ", accountHolder=" + accountHolder + "]";
	}
	
	
}
