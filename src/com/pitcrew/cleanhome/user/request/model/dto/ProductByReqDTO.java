package com.pitcrew.cleanhome.user.request.model.dto;

public class ProductByReqDTO implements java.io.Serializable {
	
	private int serNo;
	private int reqNo;
	
	public ProductByReqDTO() {}
	
	public ProductByReqDTO(int serNo, int reqNo) {
		super();
		this.serNo = serNo;
		this.reqNo = reqNo;
	}
	public int getSerNo() {
		return serNo;
	}
	public void setSerNo(int serNo) {
		this.serNo = serNo;
	}
	public int getReqNo() {
		return reqNo;
	}
	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	@Override
	public String toString() {
		return "ProductByReqDTO [serNo=" + serNo + ", reqNo=" + reqNo + "]";
	}
	
	
	
}
