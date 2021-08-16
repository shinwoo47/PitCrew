package com.pitcrew.cleanhome.admin.calculator.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.calculator.model.dto.CalculatingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.service.CalculatingService;
import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.common.paging.AdminPagenation;
import com.pitcrew.cleanhome.common.paging.SelectAdminCriteria;

@WebServlet("/admin/calculating/list")
public class SelectCalculating extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("controller 진입 성공");

		/* 계산할 금액들을 불러온다*/
		CalculatingService calculatingService = new CalculatingService();
		List<CalculatingDTO> calSettingList = calculatingService.selectCalSetting();
		
		
		
		
		/* 계산 결과를 db에 인서트 해준다.(정산 대기 상태) */
		
		
		
		
		/*계산 결과는 set으로 저장해서 화면에 보내준다*/
				
		
		
		
		/* 페이징 처리 */
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		/* 0보다 작은 숫자값을 입력해도 1페이지를 보여준다 */
		if(pageNo <= 0) {
			pageNo = 1;
		}

		String searchCondition = null;
		if(request.getParameter("searchCondition") != null && !"".equals(request.getParameter("searchCondition"))) {
			searchCondition = (request.getParameter("searchCondition"));
			
		}
		String searchValue = null;
		if(request.getParameter("searchValue") != null && !"".equals(request.getParameter("searchValue"))) {
			searchValue = (request.getParameter("searchValue"));
			
		}
		
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
		
		/* 정산상태 db랑 텍스트 일치 시키기 */
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
		
		int totalCount = calculatingService.selectTotalCount(searchMap);

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
		List<CalculatingDTO> calList = calculatingService.selectCalList(selectAdminCriteria);

		System.out.println("calList : " + calList);

		
		
		
		String path = "";
		
		/*		
		if(calList != null) {
			path = "/WEB-INF/views/admin/calculator/calList.jsp";
			request.setAttribute("calList", calList);
			request.setAttribute("selectAdminCriteria", selectAdminCriteria);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "목록 조회 실패!");
		}
*/
		
		
		request.getRequestDispatcher(path).forward(request, response);

	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
