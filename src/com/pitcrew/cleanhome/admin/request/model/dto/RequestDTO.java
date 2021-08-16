package com.pitcrew.cleanhome.admin.request.model.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.pitcrew.cleanhome.admin.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.admin.pay.model.dto.PayDTO;
import com.pitcrew.cleanhome.admin.product.model.dto.ProductInfoDTO;

public class RequestDTO implements Serializable{
	
	private int reqNo;
	private java.sql.Date serviceDate;
	private String wantThing;
	private MemberDTO cleaner;
	private MemberDTO user;
	private String status;
	private List<ProductInfoDTO> product;
	private List<PayDTO> pay;
	private List<ReqInfoDTO> reqStatusHistory;
	
	public RequestDTO() {}

	public RequestDTO(int reqNo, Date serviceDate, String wantThing, MemberDTO cleaner, MemberDTO user, String status,
			List<ProductInfoDTO> product, List<PayDTO> pay, List<ReqInfoDTO> reqStatusHistory) {
		super();
		this.reqNo = reqNo;
		this.serviceDate = serviceDate;
		this.wantThing = wantThing;
		this.cleaner = cleaner;
		this.user = user;
		this.status = status;
		this.product = product;
		this.pay = pay;
		this.reqStatusHistory = reqStatusHistory;
	}

	public int getReqNo() {
		return reqNo;
	}

	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	public java.sql.Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(java.sql.Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getWantThing() {
		return wantThing;
	}

	public void setWantThing(String wantThing) {
		this.wantThing = wantThing;
	}

	public MemberDTO getCleaner() {
		return cleaner;
	}

	public void setCleaner(MemberDTO cleaner) {
		this.cleaner = cleaner;
	}

	public MemberDTO getUser() {
		return user;
	}

	public void setUser(MemberDTO user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ProductInfoDTO> getProduct() {
		return product;
	}

	public void setProduct(List<ProductInfoDTO> product) {
		this.product = product;
	}

	public List<PayDTO> getPay() {
		return pay;
	}

	public void setPay(List<PayDTO> pay) {
		this.pay = pay;
	}

	public List<ReqInfoDTO> getReqStatusHistory() {
		return reqStatusHistory;
	}

	public void setReqStatusHistory(List<ReqInfoDTO> reqStatusHistory) {
		this.reqStatusHistory = reqStatusHistory;
	}

	@Override
	public String toString() {
		return "RequestDTO [reqNo=" + reqNo + ", serviceDate=" + serviceDate + ", wantThing=" + wantThing + ", cleaner="
				+ cleaner + ", user=" + user + ", status=" + status + ", product=" + product + ", pay=" + pay
				+ ", reqStatusHistory=" + reqStatusHistory + "]";
	}

	

	
	
	
	
	
}
