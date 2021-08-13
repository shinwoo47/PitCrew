package com.pitcrew.cleanhome.common.paging;

public class SelectAdminCriteria implements java.io.Serializable {
	
	private int pageNo;					//요청한 페이지 번호
	private int totalCount;				//전체 게시물 수
	private int limit;					//한 페이지에 보여줄 게시물 수
	private int buttonAmount;			//한 번에 보여줄 페이징 버튼의 갯수
	private int maxPage;				//가장 마지막 페이지
	private int startPage;				//한 번에 보여줄 페이징 버튼의 시작하는 페이지 수
	private int endPage;				//한 번에 보여줄 페이징 버튼의 마지막 페이지 수
	private int startRow;				//DB 조회 시 최신 글 부터 조회해야 하는 행의 시작 수
	private int endRow;					//DB 조회 시 최신글부터 조회해야 하는 행의 마지막 수
	private String searchCondition;		//검색 조건
	private String searchValue;			//검색어
	private String searchStartDate;     //검색 시작일
	private String searchEndDate;   	//검색 종료일
	private String searchStatus; 		//상태 검색
	private String searchStatusValue;	//상태 검색값
	
	
	public SelectAdminCriteria() {}


	public SelectAdminCriteria(int pageNo, int totalCount, int limit, int buttonAmount, int maxPage, int startPage,
			int endPage, int startRow, int endRow, String searchCondition, String searchValue, String searchStartDate,
			String searchEndDate, String searchStatus, String searchStatusValue) {
		super();
		this.pageNo = pageNo;
		this.totalCount = totalCount;
		this.limit = limit;
		this.buttonAmount = buttonAmount;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.startRow = startRow;
		this.endRow = endRow;
		this.searchCondition = searchCondition;
		this.searchValue = searchValue;
		this.searchStartDate = searchStartDate;
		this.searchEndDate = searchEndDate;
		this.searchStatus = searchStatus;
		this.searchStatusValue = searchStatusValue;
	}


	public int getPageNo() {
		return pageNo;
	}


	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
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


	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getStartRow() {
		return startRow;
	}


	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}


	public int getEndRow() {
		return endRow;
	}


	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}


	public String getSearchCondition() {
		return searchCondition;
	}


	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}


	public String getSearchValue() {
		return searchValue;
	}


	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}


	public String getSearchStartDate() {
		return searchStartDate;
	}


	public void setSearchStartDate(String searchStartDate) {
		this.searchStartDate = searchStartDate;
	}


	public String getSearchEndDate() {
		return searchEndDate;
	}


	public void setSearchEndDate(String searchEndDate) {
		this.searchEndDate = searchEndDate;
	}


	public String getSearchStatus() {
		return searchStatus;
	}


	public void setSearchStatus(String searchStatus) {
		this.searchStatus = searchStatus;
	}


	public String getSearchStatusValue() {
		return searchStatusValue;
	}


	public void setSearchStatusValue(String searchStatusValue) {
		this.searchStatusValue = searchStatusValue;
	}


	@Override
	public String toString() {
		return "SelectCriteria [pageNo=" + pageNo + ", totalCount=" + totalCount + ", limit=" + limit
				+ ", buttonAmount=" + buttonAmount + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", startRow=" + startRow + ", endRow=" + endRow + ", searchCondition=" + searchCondition
				+ ", searchValue=" + searchValue + ", searchStartDate=" + searchStartDate + ", searchEndDate="
				+ searchEndDate + ", searchStatus=" + searchStatus + ", searchStatusValue=" + searchStatusValue + "]";
	}

	
	
}
