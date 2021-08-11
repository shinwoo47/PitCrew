package com.pitcrew.cleanhome.admin.member.model.dto;

import java.sql.Date;

public class MemberDTO {

	private int memNo;
	private String name;
	private String id;
	private String email;
	private java.sql.Date bday;
	private String address;
	private String pwd;
	private String phone;
	private java.sql.Date enrollDate;
	private String role;
	private String status;
	private java.sql.Date entireDate;
	
	public MemberDTO() {}

	public MemberDTO(int memNo, String name, String id, String email, Date bday, String address, String pwd,
			String phone, Date enrollDate, String role, String status, Date entireDate) {
		super();
		this.memNo = memNo;
		this.name = name;
		this.id = id;
		this.email = email;
		this.bday = bday;
		this.address = address;
		this.pwd = pwd;
		this.phone = phone;
		this.enrollDate = enrollDate;
		this.role = role;
		this.status = status;
		this.entireDate = entireDate;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.util.Date getBday() {
		return bday;
	}

	public void setBday(java.sql.Date bday) {
		this.bday = bday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public java.util.Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(java.sql.Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public java.util.Date getEntireDate() {
		return entireDate;
	}

	public void setEntireDate(java.sql.Date entireDate) {
		this.entireDate = entireDate;
	}

	@Override
	public String toString() {
		return "MemberDTO [memNo=" + memNo + ", name=" + name + ", id=" + id + ", email=" + email + ", bday=" + bday
				+ ", address=" + address + ", pwd=" + pwd + ", phone=" + phone + ", enrollDate=" + enrollDate
				+ ", role=" + role + ", status=" + status + ", entireDate=" + entireDate + "]";
	}
	
	
	
}
