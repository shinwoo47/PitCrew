package com.pitcrew.cleanhome.user.model.dto;

public class CleanDTO {
	
	private String imgNo;		//사진이름
	private String name;	//청소 구역이름
	private int cleanPrice;	//청소가격
	private int cleanTime; 	//청소시간
	
	public CleanDTO() {
		super();
	}

	public CleanDTO(String imgNo, String name, int cleanPrice, int cleanTime) {
		super();
		this.imgNo = imgNo;
		this.name = name;
		this.cleanPrice = cleanPrice;
		this.cleanTime = cleanTime;
	}

	public String getImgNo() {
		return imgNo;
	}

	public void setImgNo(String imgNo) {
		this.imgNo = imgNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCleanPrice() {
		return cleanPrice;
	}

	public void setCleanPrice(int cleanPrice) {
		this.cleanPrice = cleanPrice;
	}

	public int getCleanTime() {
		return cleanTime;
	}

	public void setCleanTime(int cleanTime) {
		this.cleanTime = cleanTime;
	}

	@Override
	public String toString() {
		return "CleanDTO [imgNo=" + imgNo + ", name=" + name + ", cleanPrice=" + cleanPrice + ", cleanTime=" + cleanTime
				+ "]";
	}
	

	
	
}
