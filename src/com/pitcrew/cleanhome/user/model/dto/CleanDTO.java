package com.pitcrew.cleanhome.user.model.dto;

import java.sql.Date;

public class CleanDTO {
	
	private int cleanNo;		//청소번호
	private String name;		//청소 구역이름
	private String content;		//청소소개
	private double time; 		//청소시간
	private int price;			//청소가격
	private String category;	//카테고리
	private String imgNo;		//사진이름
	private int productNo;		//상품번호
	private int optionNo1;		//옵션번호1
	private int optionNo2;		//옵션번호2
	private int proPrice;		//의뢰가격
	
	private String demand;		//요구사항
	
	private int reqNo;			//의뢰번호
	private Date reqDate;		//의뢰일시
	private String reqReq;		//요청사항
	private int memNoUser;		//회원번호
	
	private String reqCon;		//의뢰상태
	
	
	
	public CleanDTO() {
		super();
	}


	public CleanDTO(int cleanNo, String name, String content, double time, int price, String category, String imgNo,
			int productNo, int optionNo1, int optionNo2, int proPrice, String demand) {
		super();
		this.cleanNo = cleanNo;
		this.name = name;
		this.content = content;
		this.time = time;
		this.price = price;
		this.category = category;
		this.imgNo = imgNo;
		this.productNo = productNo;
		this.optionNo1 = optionNo1;
		this.optionNo2 = optionNo2;
		this.proPrice = proPrice;
		this.demand = demand;
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


	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}


	public int getOptionNo1() {
		return optionNo1;
	}


	public void setOptionNo1(int optionNo1) {
		this.optionNo1 = optionNo1;
	}


	public int getOptionNo2() {
		return optionNo2;
	}


	public void setOptionNo2(int optionNo2) {
		this.optionNo2 = optionNo2;
	}


	public int getProPrice() {
		return proPrice;
	}


	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}


	public String getDemand() {
		return demand;
	}


	public void setDemand(String demand) {
		this.demand = demand;
	}


	@Override
	public String toString() {
		return "CleanDTO [cleanNo=" + cleanNo + ", name=" + name + ", content=" + content + ", time=" + time
				+ ", price=" + price + ", category=" + category + ", imgNo=" + imgNo + ", productNo=" + productNo
				+ ", optionNo1=" + optionNo1 + ", optionNo2=" + optionNo2 + ", proPrice=" + proPrice + ", demand="
				+ demand + "]";
	}
	
	
}