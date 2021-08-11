package com.pitcrew.cleanhome.cleaner.request.model.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable{
 
	private int serNo;
	private String serName;
	private String serContent;
	private double SerTime;
	private int precSerNo;
	private int serPrice;
	
	public ProductDTO () {}

	public ProductDTO(int serNo, String serName, String serContent, double serTime, int precSerNo, int serPrice) {
		super();
		this.serNo = serNo;
		this.serName = serName;
		this.serContent = serContent;
		SerTime = serTime;
		this.precSerNo = precSerNo;
		this.serPrice = serPrice;
	}

	public int getSerNo() {
		return serNo;
	}

	public void setSerNo(int serNo) {
		this.serNo = serNo;
	}

	public String getSerName() {
		return serName;
	}

	public void setSerName(String serName) {
		this.serName = serName;
	}

	public String getSerContent() {
		return serContent;
	}

	public void setSerContent(String serContent) {
		this.serContent = serContent;
	}

	public double getSerTime() {
		return SerTime;
	}

	public void setSerTime(double serTime) {
		SerTime = serTime;
	}

	public int getPrecSerNo() {
		return precSerNo;
	}

	public void setPrecSerNo(int precSerNo) {
		this.precSerNo = precSerNo;
	}

	public int getSerPrice() {
		return serPrice;
	}

	public void setSerPrice(int serPrice) {
		this.serPrice = serPrice;
	}

	@Override
	public String toString() {
		return "ProductDTO [serNo=" + serNo + ", serName=" + serName + ", serContent=" + serContent + ", SerTime="
				+ SerTime + ", precSerNo=" + precSerNo + ", serPrice=" + serPrice + "]";
	}
	
	
}
