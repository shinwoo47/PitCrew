package com.pitcrew.cleanhome.admin.signupapproval.model.dto;

import java.sql.Date;

import com.pitcrew.cleanhome.admin.user.model.dto.UserDTO;

public class SignUpApprovalDTO {
	
	private int memNo;
	private String identifyYn;
	private String educateYn;
	private Date identifyDate;
	private Date educateDate;
	private String accountNo;
	private String bankName;
	private String accountHolder;
	private UserDTO memId;
	private UserDTO memName;
	
	public SignUpApprovalDTO() {}
	
	public SignUpApprovalDTO(int memNo, String identifyYn, String educateYn, Date identifyDate, Date educateDate,
			String accountNo, String bankName, String accountHolder, UserDTO memId, UserDTO memName) {
		super();
		this.memNo = memNo;
		this.identifyYn = identifyYn;
		this.educateYn = educateYn;
		this.identifyDate = identifyDate;
		this.educateDate = educateDate;
		this.accountNo = accountNo;
		this.bankName = bankName;
		this.accountHolder = accountHolder;
		this.memId = memId;
		this.memName = memName;
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
	public String getEducateYn() {
		return educateYn;
	}
	public void setEducateYn(String educateYn) {
		this.educateYn = educateYn;
	}
	public Date getIdentifyDate() {
		return identifyDate;
	}
	public void setIdentifyDate(Date identifyDate) {
		this.identifyDate = identifyDate;
	}
	public Date getEducateDate() {
		return educateDate;
	}
	public void setEducateDate(Date educateDate) {
		this.educateDate = educateDate;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public UserDTO getMemId() {
		return memId;
	}
	public void setMemId(UserDTO memId) {
		this.memId = memId;
	}
	public UserDTO getMemName() {
		return memName;
	}
	public void setMemName(UserDTO memName) {
		this.memName = memName;
	}
	
	@Override
	public String toString() {
		return "SignUpApprovalDTO [memNo=" + memNo + ", identifyYn=" + identifyYn + ", educateYn=" + educateYn
				+ ", identifyDate=" + identifyDate + ", educateDate=" + educateDate + ", accountNo=" + accountNo
				+ ", bankName=" + bankName + ", accountHolder=" + accountHolder + ", memId=" + memId + ", memName="
				+ memName + "]";
	}
	
}
