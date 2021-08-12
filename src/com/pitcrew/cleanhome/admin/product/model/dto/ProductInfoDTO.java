package com.pitcrew.cleanhome.admin.product.model.dto;

public class ProductInfoDTO {
	private int productNo;
	private String productName; 
	private double serviceTime;
	private String productCategory;
	
	
	public ProductInfoDTO() {}
	
	public ProductInfoDTO(int productNo, String productName, double serviceTime, String productCategory) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.serviceTime = serviceTime;
		this.productCategory = productCategory;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(double serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "ProductInfoDTO [productNo=" + productNo + ", productName=" + productName + ", serviceTime="
				+ serviceTime + ", productCategory=" + productCategory + "]";
	}
	
	
}
