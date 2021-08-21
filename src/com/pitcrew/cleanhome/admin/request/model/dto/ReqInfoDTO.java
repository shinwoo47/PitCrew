package com.pitcrew.cleanhome.admin.request.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class ReqInfoDTO {
	private int reqInfoNo;
	private int reqNo;
	private String status;
	private java.sql.Date date;
	
	public ReqInfoDTO() {}

	public ReqInfoDTO(int reqInfoNo, int reqNo, String status, Date date) {
		super();
		this.reqInfoNo = reqInfoNo;
		this.reqNo = reqNo;
		this.status = status;
		this.date = date;
	}

	public int getReqInfoNo() {
		return reqInfoNo;
	}

	public void setReqInfoNo(int reqInfoNo) {
		this.reqInfoNo = reqInfoNo;
	}

	public int getReqNo() {
		return reqNo;
	}

	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ReqInfoDTO [reqInfoNo=" + reqInfoNo + ", reqNo=" + reqNo + ", status=" + status + ", date=" + date
				+ "]";
	}
	
	
}
