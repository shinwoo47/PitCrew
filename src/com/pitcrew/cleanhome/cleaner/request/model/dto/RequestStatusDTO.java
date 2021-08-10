package com.pitcrew.cleanhome.cleaner.request.model.dto;

import java.io.Serializable;

public class RequestStatusDTO implements Serializable{

	private int reqConNo;
	private String reqCon;
	private RequestDTO reqNo;
	
	public RequestStatusDTO() {}

	public RequestStatusDTO(int reqConNo, String reqCon, RequestDTO reqNo) {
		super();
		this.reqConNo = reqConNo;
		this.reqCon = reqCon;
		this.reqNo = reqNo;
	}

	public int getReqConNo() {
		return reqConNo;
	}

	public void setReqConNo(int reqConNo) {
		this.reqConNo = reqConNo;
	}

	public String getReqCon() {
		return reqCon;
	}

	public void setReqCon(String reqCon) {
		this.reqCon = reqCon;
	}

	public RequestDTO getReqNo() {
		return reqNo;
	}

	public void setReqNo(RequestDTO reqNo) {
		this.reqNo = reqNo;
	}

	@Override
	public String toString() {
		return "RequestStatusDTO [reqConNo=" + reqConNo + ", reqCon=" + reqCon + ", reqNo=" + reqNo + "]";
	}
	
	
}
