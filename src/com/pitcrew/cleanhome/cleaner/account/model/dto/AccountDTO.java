package com.pitcrew.cleanhome.cleaner.account.model.dto;



import java.util.Date;

public class AccountDTO {

	private int accountHisCode;
	private int memNo;
	private Date accountChangeDate;
	private String preAccountNo;
	private String preBankName;
	private String preAccountHolder;
	
	public AccountDTO() {}

	public AccountDTO(int accountHisCode, int memNo, Date accountChangeDate, String preAccountNo,
			String preBankName, String preAccountHolder) {
		super();
		this.accountHisCode = accountHisCode;
		this.memNo = memNo;
		this.accountChangeDate = accountChangeDate;
		this.preAccountNo = preAccountNo;
		this.preBankName = preBankName;
		this.preAccountHolder = preAccountHolder;
	}

	public int getAccountHisCode() {
		return accountHisCode;
	}

	public void setAccountHisCode(int accountHisCode) {
		this.accountHisCode = accountHisCode;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public Date getAccountChangeDate() {
		return accountChangeDate;
	}

	public void setAccountChangeDate(Date accountChangeDate) {
		this.accountChangeDate = accountChangeDate;
	}

	public String getPreAccountNo() {
		return preAccountNo;
	}

	public void setPreAccountNo(String preAccountNo) {
		this.preAccountNo = preAccountNo;
	}

	public String getPreBankName() {
		return preBankName;
	}

	public void setPreBankName(String preBankName) {
		this.preBankName = preBankName;
	}

	public String getPreAccountHolder() {
		return preAccountHolder;
	}

	public void setPreAccountHolder(String preAccountHolder) {
		this.preAccountHolder = preAccountHolder;
	}

	@Override
	public String toString() {
		return "AccountDTO [accountHisCode=" + accountHisCode + ", memNo=" + memNo + ", accountChangeDate="
				+ accountChangeDate + ", preAccountNo=" + preAccountNo + ", preBankName=" + preBankName
				+ ", preAccountHolder=" + preAccountHolder + "]";
	}

}
