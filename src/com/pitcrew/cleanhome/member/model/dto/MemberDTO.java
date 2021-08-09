package com.pitcrew.cleanhome.member.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class MemberDTO implements Serializable{

	private int memNo;
	private String memName;
	private String id;
	private String email;
	private Date birth;
	private String address;
	private String pwd;
	private String phone;
	private Date enrollDate;
	private String role;
	private String entYn;
	private Date entDate;
	
	public MemberDTO() {}

	public MemberDTO(int memNo, String memName, String id, String email, Date birth, String address, String pwd,
			String phone, Date enrollDate, String role, String entYn, Date entDate) {
		super();
		this.memNo = memNo;
		this.memName = memName;
		this.id = id;
		this.email = email;
		this.birth = birth;
		this.address = address;
		this.pwd = pwd;
		this.phone = phone;
		this.enrollDate = enrollDate;
		this.role = role;
		this.entYn = entYn;
		this.entDate = entDate;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
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

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEntYn() {
		return entYn;
	}

	public void setEntYn(String entYn) {
		this.entYn = entYn;
	}

	public Date getEntDate() {
		return entDate;
	}

	public void setEntDate(Date entDate) {
		this.entDate = entDate;
	}

	@Override
	public String toString() {
		return "MemberDTO [memNo=" + memNo + ", memName=" + memName + ", id=" + id + ", email=" + email + ", birth="
				+ birth + ", address=" + address + ", pwd=" + pwd + ", phone=" + phone + ", enrollDate=" + enrollDate
				+ ", role=" + role + ", entYn=" + entYn + ", entDate=" + entDate + "]";
	}

	

	
	
	
	
}
