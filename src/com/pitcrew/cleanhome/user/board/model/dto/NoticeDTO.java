package com.pitcrew.cleanhome.user.board.model.dto;

import java.sql.Date; 

import com.pitcrew.cleanhome.admin.member.model.dto.MemberDTO;

public class NoticeDTO {

	private int no;
	private String title;
	private String content;
	private String category;
	private java.sql.Date writeDate;
	private int writerMemberNo;
	private String writer;
	private String status;
	private int count;
	private MemberDTO role;
	private String forWho;
	
	public NoticeDTO() {}

	public NoticeDTO(int no, String title, String content, String category, Date writeDate, int writerMemberNo,
			String writer, String status, int count, MemberDTO role, String forWho) {
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
		this.forWho = forWho;
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

	public void setWriteDate(java.sql.Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getWriterMemberNo() {
		return writerMemberNo;
	}

	public void setWriterMemberNo(int writerMemberNo) {
		this.writerMemberNo = writerMemberNo;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
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

	public String getForWho() {
		return forWho;
	}

	public void setForWho(String forWho) {
		this.forWho = forWho;
	}

	@Override
	public String toString() {
		return "NoticeDTO [no=" + no + ", title=" + title + ", content=" + content + ", category=" + category
				+ ", writeDate=" + writeDate + ", writerMemberNo=" + writerMemberNo + ", writer=" + writer + ", status="
				+ status + ", count=" + count + ", role=" + role + ", forWho=" + forWho + "]";
	}

	
	
	

	
}
