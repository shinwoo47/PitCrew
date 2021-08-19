package com.pitcrew.cleanhome.admin.request.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.admin.request.model.service.RequestService;
import com.pitcrew.cleanhome.common.paging.AdminPagenation;
import com.pitcrew.cleanhome.common.paging.SelectAdminCriteria;

@WebServlet("/admin/request/list")
public class SelectRequestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("controller 진입 성공");

		/* 목록보기를 눌렀을 시 가장 처음에 보여지는 페이지는 1페이지이다.
		 * 파라미터로 전달되는 페이지가 있는 경우 currentPage는 파라미터로 전달받은 페이지 수 이다.
		 * */
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		/* 0보다 작은 숫자값을 입력해도 1페이지를 보여준다 */
		if(pageNo <= 0) {
			pageNo = 1;
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		String searchStartDate = null;
		if(request.getParameter("searchStartDate") != null && !"".equals(request.getParameter("searchStartDate"))) {
			searchStartDate = (request.getParameter("searchStartDate"));
		}
		
		String searchEndDate = null;
		if(request.getParameter("searchEndDate") != null && !"".equals(request.getParameter("searchEndDate"))) {
			searchEndDate = (request.getParameter("searchEndDate"));
		}
		
		
		String searchStatus = request.getParameter("searchStatus");
		String searchStatusValue = null;		
		if(request.getParameter("statusValue") != null && !"".equals(request.getParameter("statusValue"))) {
			switch(request.getParameter("statusValue")) {
				case "매칭 신청" : searchStatusValue = "등록"; break;
				case "매칭 완료" : searchStatusValue = "매칭"; break;
				case "종료된 의뢰" : searchStatusValue = "완료"; break;
				case "취소 요청" : searchStatusValue = "취소요청"; break;
				case "의뢰 취소" : searchStatusValue = "취소"; break;
				case "수정 요청" : searchStatusValue = "수정요청"; break;
				case "수정된 의뢰" : searchStatusValue = "수정"; break;
				default : break;
			}
		}
		
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition); //검색어 입력
		searchMap.put("searchValue", searchValue); // 입력 값
		searchMap.put("searchStartDate", searchStartDate); // 날짜 조회
		searchMap.put("searchEndDate", searchEndDate); // 날짜 조회
		searchMap.put("searchStatus", searchStatus); // 상태 선택
		searchMap.put("searchStatusValue", searchStatusValue);
		
		/* 전체 게시물 수가 필요하다.
		 * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
		 * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
		 * */
		RequestService requestService = new RequestService();
		int totalCount = requestService.selectTotalCount(searchMap);

		System.out.println("totalCount : " + totalCount);

		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 15;		
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;

		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectAdminCriteria selectAdminCriteria = null;

		if(searchCondition != null && !"".equals(searchCondition)) {
			selectAdminCriteria = AdminPagenation.getSelectAdminCriteria(pageNo, totalCount, limit, buttonAmount, 
										searchCondition, searchValue, searchStartDate, searchEndDate, searchStatus, searchStatusValue);
		} else {
			selectAdminCriteria = AdminPagenation.getSelectAdminCriteria(pageNo, totalCount, limit, buttonAmount);
		}

		System.out.println(selectAdminCriteria);

		/* 조회해온다 */
		List<RequestDTO> requestList = requestService.selectRequestList(selectAdminCriteria);

		System.out.println("requestList : " + requestList);

		String path = "";
		if(!requestList.isEmpty() || requestList != null) {
			path = "/WEB-INF/views/admin/request/requestList.jsp";
			request.setAttribute("requestList", requestList);
			request.setAttribute("selectAdminCriteria", selectAdminCriteria);
		} 

		
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
