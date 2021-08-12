package com.pitcrew.cleanhome.admin.product.model.dto;

import java.util.List;

public class ProductReqDTO {

	private List<ProductInfoDTO> productNo;
	private int reqNo;
	private List<ProductInfoDTO> productName;
	
	public ProductReqDTO() {}

	public ProductReqDTO(List<ProductInfoDTO> productNo, int reqNo, List<ProductInfoDTO> productName) {
		super();
		this.productNo = productNo;
		this.reqNo = reqNo;
		this.productName = productName;
	}

	public List<ProductInfoDTO> getProductNo() {
		return productNo;
	}

	public void setProductNo(List<ProductInfoDTO> productNo) {
		this.productNo = productNo;
	}

	public int getReqNo() {
		return reqNo;
	}

	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	public List<ProductInfoDTO> getProductName() {
		return productName;
	}

	public void setProductName(List<ProductInfoDTO> productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "ProductReqDTO [productNo=" + productNo + ", reqNo=" + reqNo + ", productName=" + productName + "]";
	}

	
	
	
}
