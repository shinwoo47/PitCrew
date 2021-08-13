package com.pitcrew.cleanhome.cleaner.request.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.cleaner.request.model.service.RequestService;
import com.pitcrew.cleanhome.cleaner.request.paging.Pagenation;
import com.pitcrew.cleanhome.cleaner.request.paging.SelectCriteria;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;


@WebServlet("/cleaner/request/ajax")
public class RequestAjax extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO member =((MemberDTO) session.getAttribute("loginMember"));
		int memNo = member.getMemNo();
		RequestDTO cleanerRequest = new RequestDTO();
		cleanerRequest.setMemNoCleaner(memNo);
		cleanerRequest.setReqStatus("매칭");

		String searchDate = (request.getParameter("date"));
		System.out.println("date : " + searchDate);
		
		String currentPage = request.getParameter("currentPage");
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
	
		/* 0보다 작은 숫자값을 입력해도 1페이지를 보여준다 */
		if(pageNo <= 0) {
			pageNo = 1;
		}

		if(request.getParameter("date") != null && !"".equals(request.getParameter("date"))) {
			searchDate = (request.getParameter("searchDate"));
		}
		
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchDate", searchDate);
		
		/* 전체 게시물 수가 필요하다.
		 * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
		 * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
		 * */
		RequestService requestService = new RequestService();
		int totalCount = requestService.selectCleanerTotalCount(searchMap);
		
		System.out.println("totalBoardCount : " + totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 5;		//얘도 파라미터로 전달받아도 된다.
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;
		
		if((searchDate != null && !"".equals(searchDate)) ) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchDate);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println("selectCriteria" + selectCriteria);
		
		/* 조회해온다 */
		List<RequestDTO> requestList = requestService.selectRequestList(selectCriteria);


		String jsonString = new Gson().toJson(requestList);
		
		System.out.println(jsonString);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(jsonString);
		System.out.println(jsonString);
		
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
