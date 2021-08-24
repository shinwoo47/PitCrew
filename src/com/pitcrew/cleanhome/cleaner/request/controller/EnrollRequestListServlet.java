package com.pitcrew.cleanhome.cleaner.request.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.cleaner.request.model.service.RequestService;
import com.pitcrew.cleanhome.cleaner.request.paging.Pagenation;
import com.pitcrew.cleanhome.cleaner.request.paging.SelectCriteria;


@WebServlet("/cleaner/request/enroll")
public class EnrollRequestListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		String searchValue = request.getParameter("searchValue");
		String searchDate = null;
		if(request.getParameter("searchDate") != null && !"".equals(request.getParameter("searchDate"))) {
			searchDate = (request.getParameter("searchDate"));
		}
		
		/* 입력받은 장소와 날짜를 검색 맵에 입력 */
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchValue", searchValue);
		searchMap.put("searchDate", searchDate);

		/* 검색 맵을 이용하여 조회할 리스트의 갯수를 반환*/
		RequestService requestService = new RequestService();
		int totalCount = requestService.selectTotalCount(searchMap);
		
		/* 한 번에 보여줄 목록의 갯수*/
		int limit = 10;		
		
		/* 페이징 버튼의 최대 갯수*/
		int buttonAmount = 5;

		/* 페이징을 위해 설정한 값들을 이용하여 검색하기 위한 dto를 생성자를 이용하여 생성*/
		SelectCriteria selectCriteria = null;		
		if((searchDate != null && !"".equals(searchDate)) || (searchValue != null && !"".equals(searchValue))) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchValue, searchDate);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		/* 검색을 위한 dto를 이용하여 조건에 맞는 리스트를 반환*/
		List<RequestDTO> requestList = requestService.selectRequestList(selectCriteria);
	
		String path = "";
		if(requestList != null) {
			path = "/WEB-INF/views/cleaner/request.jsp";
			request.setAttribute("requestList", requestList);
			request.setAttribute("selectCriteria", selectCriteria);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "의뢰 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
