package com.pitcrew.cleanhome.common.paging;

public class CleanCriteria {
	
	private int pageNo;					//요청한 페이지 번호
	private int limit;					//한 페이지에 보여줄 게시물 수
	private int buttonAmount;			//한 번에 보여줄 페이징 버튼의 갯수
	
	public CleanCriteria() {
		super();
	}

	public CleanCriteria(int pageNo, int limit, int buttonAmount) {
		super();
		this.pageNo = pageNo;
		this.limit = limit;
		this.buttonAmount = buttonAmount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getButtonAmount() {
		return buttonAmount;
	}

	public void setButtonAmount(int buttonAmount) {
		this.buttonAmount = buttonAmount;
	}

	@Override
	public String toString() {
		return "cleanCriteria [pageNo=" + pageNo + ", limit=" + limit + ", buttonAmount=" + buttonAmount + "]";
	}
	
	


}
