package com.pitcrew.cleanhome.admin.product.model.dto;

public class ProductDTO {
	
	private int serNo;
	private String serName;
	private String serContent;
	private int serTime;
	private int serPrice;
	private String serCategory;
	
	public ProductDTO() {}

	public ProductDTO(int serNo, String serName, String serContent, int serTime, int serPrice, String serCategory) {
		super();
		this.serNo = serNo;
		this.serName = serName;
		this.serContent = serContent;
		this.serTime = serTime;
		this.serPrice = serPrice;
		this.serCategory = serCategory;
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

	public int getSerTime() {
		return serTime;
	}

	public void setSerTime(int serTime) {
		this.serTime = serTime;
	}

	public int getSerPrice() {
		return serPrice;
	}

	public void setSerPrice(int serPrice) {
		this.serPrice = serPrice;
	}

	public String getSerCategory() {
		return serCategory;
	}

	public void setSerCategory(String serCategory) {
		this.serCategory = serCategory;
	}

	@Override
	public String toString() {
		return "ProductDTO [serNo=" + serNo + ", serName=" + serName + ", serContent=" + serContent + ", serTime="
				+ serTime + ", serPrice=" + serPrice + ", serCategory=" + serCategory + "]";
	}
	
	
}
