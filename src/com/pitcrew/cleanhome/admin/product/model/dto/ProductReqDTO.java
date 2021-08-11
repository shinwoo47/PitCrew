package com.pitcrew.cleanhome.admin.product.model.dto;

public class ProductReqDTO {

	private int productNo;
	private int reqNo;
	private ProductInfoDTO productName;
	
	public ProductReqDTO() {}

	public ProductReqDTO(int productNo, int reqNo) {
		super();
		this.productNo = productNo;
		this.reqNo = reqNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getReqNo() {
		return reqNo;
	}

	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	@Override
	public String toString() {
		return "ProductReqDTO [productNo=" + productNo + ", reqNo=" + reqNo + "]";
	}
	
	
}
