package com.pitcrew.cleanhome.cleaner.request.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class RequestDTO implements Serializable{

	private int reqNo;
	private Date reqDate;
	private String reqReq;
	private int memNoCleaner;
	private int memNoUser;
	private String reqStatus;
	
	public RequestDTO() {}

	public RequestDTO(int reqNo, Date reqDate, String reqReq, int memNoCleaner, int memNoUser, String reqStatus) {
		super();
		this.reqNo = reqNo;
		this.reqDate = reqDate;
		this.reqReq = reqReq;
		this.memNoCleaner = memNoCleaner;
		this.memNoUser = memNoUser;
		this.reqStatus = reqStatus;
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

	public String getReqReq() {
		return reqReq;
	}

	public void setReqReq(String reqReq) {
		this.reqReq = reqReq;
	}

	public int getMemNoCleaner() {
		return memNoCleaner;
	}

	public void setMemNoCleaner(int memNoCleaner) {
		this.memNoCleaner = memNoCleaner;
	}

	public int getMemNoUser() {
		return memNoUser;
	}

	public void setMemNoUser(int memNoUser) {
		this.memNoUser = memNoUser;
	}

	public String getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}

	@Override
	public String toString() {
		return "RequestDTO [reqNo=" + reqNo + ", reqDate=" + reqDate + ", reqReq=" + reqReq + ", memNoCleaner="
				+ memNoCleaner + ", memNoUser=" + memNoUser + ", reqStatus=" + reqStatus + "]";
	}
	
	
}
