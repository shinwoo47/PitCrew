package com.pitcrew.cleanhome.admin.notice.model.dto;

import java.util.Date;

import com.pitcrew.cleanhome.admin.member.model.dto.MemberDTO;

public class NoticeDTO {

	private int no;
	private String title;
	private String content;
	private String category;
	private java.util.Date writeDate;
	private int writerMemberNo;
	private MemberDTO writer;
	private String status;
	private int count;
	private MemberDTO role;
	
	public NoticeDTO() {}

	public NoticeDTO(int no, String title, String content, String category, Date writeDate, int writerMemberNo,
			MemberDTO writer, String status, int count, MemberDTO role) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.category = category;
		this.writeDate = writeDate;
		this.writerMemberNo = writerMemberNo;
		this.writer = writer;
		this.status = status;
		this.count = count;
		this.role = role;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public java.util.Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(java.util.Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getWriterMemberNo() {
		return writerMemberNo;
	}

	public void setWriterMemberNo(int writerMemberNo) {
		this.writerMemberNo = writerMemberNo;
	}

	public MemberDTO getWriter() {
		return writer;
	}

	public void setWriter(MemberDTO writer) {
		this.writer = writer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public MemberDTO getRole() {
		return role;
	}

	public void setRole(MemberDTO role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "NoticeDTO [no=" + no + ", title=" + title + ", content=" + content + ", category=" + category
				+ ", writeDate=" + writeDate + ", writerMemberNo=" + writerMemberNo + ", writer=" + writer + ", status="
				+ status + ", count=" + count + ", role=" + role + "]";
	}

	
	

	
}
