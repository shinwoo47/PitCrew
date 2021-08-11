package com.pitcrew.cleanhome.user.model.dto;

import java.sql.Date;

public class UserDTO implements java.io.Serializable {
	
	private int no;
	private String userName;
	private String userId;
	private String email;
	private Date birth;
	private String address;
	private String userPwd;
	private String userPhone;
	private Date userEnrollDate;
	private String role;
	private String userEntYn; 
	private Date userEntDate;
	
	public UserDTO() {}

	public UserDTO(int no, String userName, String userId, String email, Date birth, String address, String userPwd,
			String userPhone, Date userEnrollDate, String role, String userEntYn, Date userEntDate) {
		super();
		this.no = no;
		this.userName = userName;
		this.userId = userId;
		this.email = email;
		this.birth = birth;
		this.address = address;
		this.userPwd = userPwd;
		this.userPhone = userPhone;
		this.userEnrollDate = userEnrollDate;
		this.role = role;
		this.userEntYn = userEntYn;
		this.userEntDate = userEntDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Date getUserEnrollDate() {
		return userEnrollDate;
	}

	public void setUserEnrollDate(Date userEnrollDate) {
		this.userEnrollDate = userEnrollDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserEntYn() {
		return userEntYn;
	}

	public void setUserEntYn(String userEntYn) {
		this.userEntYn = userEntYn;
	}

	public Date getUserEntDate() {
		return userEntDate;
	}

	public void setUserEntDate(Date userEntDate) {
		this.userEntDate = userEntDate;
	}

	@Override
	public String toString() {
		return "UserDTO [no=" + no + ", userName=" + userName + ", userId=" + userId + ", email=" + email + ", birth="
				+ birth + ", address=" + address + ", userPwd=" + userPwd + ", userPhone=" + userPhone
				+ ", userEnrollDate=" + userEnrollDate + ", role=" + role + ", userEntYn=" + userEntYn
				+ ", userEntDate=" + userEntDate + "]";
	}
	
	
	
}