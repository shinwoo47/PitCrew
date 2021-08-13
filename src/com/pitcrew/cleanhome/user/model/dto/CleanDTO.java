package com.pitcrew.cleanhome.user.model.dto;

public class CleanDTO {
	
	private int cleanNo;		//청소번호
	private String name;		//청소 구역이름
	private String content;		//청소내용
	private double time; 		//청소시간
	private int price;			//청소가격
	private String category;	//카테고리
	private String imgNo;		//사진이름
	
	public CleanDTO() {
		super();
	}

	public CleanDTO(int cleanNo, String name, String content, double time, int price, String category, String imgNo) {
		super();
		this.cleanNo = cleanNo;
		this.name = name;
		this.content = content;
		this.time = time;
		this.price = price;
		this.category = category;
		this.imgNo = imgNo;
	}

	public int getCleanNo() {
		return cleanNo;
	}

	public void setCleanNo(int cleanNo) {
		this.cleanNo = cleanNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImgNo() {
		return imgNo;
	}

	public void setImgNo(String imgNo) {
		this.imgNo = imgNo;
	}

	@Override
	public String toString() {
		return "CleanDTO [cleanNo=" + cleanNo + ", name=" + name + ", content=" + content + ", time=" + time
				+ ", price=" + price + ", category=" + category + ", imgNo=" + imgNo + "]";
	}

	

	
	
}
