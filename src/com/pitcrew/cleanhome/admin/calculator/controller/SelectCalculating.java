package com.pitcrew.cleanhome.admin.calculator.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.calculator.model.dto.CalSettingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.CalculatingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.DeductRateDTO;
import com.pitcrew.cleanhome.admin.calculator.model.service.CalculatingService;
import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.common.paging.AdminPagenationForCal;
import com.pitcrew.cleanhome.common.paging.SelectAdminCriteriaForCal;

@WebServlet("/admin/calculating/list")
public class SelectCalculating extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("controller 진입 성공");

		


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

		String searchStatusValue = null;

		/* 정산상태 db랑 텍스트 일치 시키기 */
		if(request.getParameter("statusValue") != null && !"".equals(request.getParameter("statusValue"))) {
			searchStatusValue = (request.getParameter("statusValue"));
		}


		Map<String, String> searchWord = new HashMap<>();
		searchWord.put("searchCondition", searchCondition);  //검색어 입력
		searchWord.put("searchValue", searchValue); 		// 입력 값
		searchWord.put("searchStatus", searchStatusValue); // 정산 상태 선택 

		/* 전체 게시물 수가 필요하다.
		 * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
		 * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
		 * */

		int totalCount = calculatingService.selectTotalCount(searchWord);

		System.out.println("totalCount : " + totalCount);

		/* 한 페이지에 보여 줄 게시물 수 */	
		int limit = 15;	
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5; 

		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다.*/
		SelectAdminCriteriaForCal selectAdminCriteriaForCal = null;

		if(searchCondition != null && !"".equals(searchCondition)) {
			selectAdminCriteriaForCal = AdminPagenationForCal.getSelectAdminCriteriaForCal(pageNo, totalCount, limit, buttonAmount, 
										searchCondition, searchValue, searchStartDate, searchEndDate, searchStatusValue);
		} else {
			selectAdminCriteriaForCal = AdminPagenationForCal.getSelectAdminCriteriaForCal(pageNo, totalCount, limit, buttonAmount);
		}

		System.out.println(selectAdminCriteriaForCal); 

		/* 조회해온다 
		List<CalculatingDTO> calList = calculatingService.selectCalList(selectAdminCriteriaForCal);
		System.out.println("calList : " + calList);

		Map<String, List<CalculatingDTO>> buckitList = new HashMap<>();
		List<CalculatingDTO> buckit;
		
		int cleanerincome = 0;
		int incometax = 0;
		int residenttax = 0;
		int cleanertransferPrice = 0;
		
		for(CalculatingDTO calc : calList) {
			String cleanerNo = String.valueOf(calc.getCleanerNo());
			if(buckitList.keySet().contains(cleanerNo)) {
				buckit = buckitList.get(cleanerNo);
				buckit.add(calc);
				for(int i = 0; i < buckit.size(); i++) {
					cleanerincome += buckit.get(i).getCleanerIncome();
					incometax += buckit.get(i).getIncometax();
					residenttax += buckit.get(i).getResidenttax();
					cleanertransferPrice += buckit.get(i).getCleanerTransferPrice();
				}
			} else {
				buckit = new ArrayList<>();
				buckit.add(calc);
				buckitList.put(cleanerNo, buckit);
			}
			
		}*/
		
		
		
		
		
		/*
		*/
		

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



		request.getRequestDispatcher(path).forward(request, response);*/

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
