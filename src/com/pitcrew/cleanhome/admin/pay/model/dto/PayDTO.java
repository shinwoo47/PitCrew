package com.pitcrew.cleanhome.admin.pay.model.dto;

import java.sql.Date;

public class PayDTO {

	private int payNo;
	private String card;
	private int price;
	private java.sql.Date payDate;
	private String approvedNo;
	private int reqNo;
	
	public PayDTO() {}

	public PayDTO(int payNo, String card, int price, Date payDate, String approvedNo, int reqNo) {
		super();
		this.payNo = payNo;
		this.card = card;
		this.price = price;
		this.payDate = payDate;
		this.approvedNo = approvedNo;
		this.reqNo = reqNo;
	}

	public int getPayNo() {
		return payNo;
	}

	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public java.sql.Date getPayDate() {
		return payDate;
	}

	public void setPayDate(java.sql.Date payDate) {
		this.payDate = payDate;
	}

	public String getApprovedNo() {
		return approvedNo;
	}

	public void setApprovedNo(String approvedNo) {
		this.approvedNo = approvedNo;
	}

	public int getReqNo() {
		return reqNo;
	}

	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	@Override
	public String toString() {
		return "PayDTO [payNo=" + payNo + ", card=" + card + ", price=" + price + ", payDate=" + payDate
				+ ", approvedNo=" + approvedNo + ", reqNo=" + reqNo + "]";
	}
	
	
}
