package com.pitcrew.cleanhome.user.request.model.dto;

public class ReqInfoDTO implements java.io.Serializable {
	
	/* 의뢰 상태 관리하는 DTO*/
	
	private int reqConNo;
	private String reqCon;
	private int reqNo;
	
	public ReqInfoDTO() {}

	public ReqInfoDTO(int reqConNo, String reqCon, int reqNo) {
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

	public int getReqNo() {
		return reqNo;
	}

	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	@Override
	public String toString() {
		return "ReqInfoDTO [reqConNo=" + reqConNo + ", reqCon=" + reqCon + ", reqNo=" + reqNo + "]";
	}

	
	
	
}
