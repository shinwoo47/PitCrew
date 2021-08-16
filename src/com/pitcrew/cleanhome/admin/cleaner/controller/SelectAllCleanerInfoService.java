package com.pitcrew.cleanhome.admin.cleaner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.cleaner.model.dto.CleanerDTO;
import com.pitcrew.cleanhome.admin.cleaner.model.service.CleanerService;

@WebServlet("/admin/select/allcleanerinfo")
public class SelectAllCleanerInfoService extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 관리자 검색 카테고리 
	    String searchCondition = "";
	    if (request.getParameter("searchCondition") !=  null) {
	    	searchCondition = request.getParameter("searchCondition");
	    }
	    
	    if(searchCondition.equals("")) { // 사용자 관리 페이지에 처음 들어왔을 경우,
	    	List<CleanerDTO> cleanerList = new CleanerService().selectAllCleanerInfoList();
	    	
	    	String path = "";
	         if(cleanerList != null) {
	            path = "/WEB-INF/views/admin/cleaner/cleanerList.jsp";
	            request.setAttribute("cleanerList", cleanerList);
	         } else {
	            path = "/WEB-INF/views/common/failed.jsp";
	            request.setAttribute("message", "해결사 정보 조회 실패!");
	         }
	         
	         request.getRequestDispatcher(path).forward(request, response);
	    	
	    }else { // 사용자 관리 페이지에서 검색을 할 경우,

	         String searchResult = request.getParameter("searchResult");
	         
			/*
			 * String searchDate = request.getParameter("searchDate"); // 신원조회 시작하는 날짜
			 * java.sql.Date date = null; if (!searchDate.equals("")) { date =
			 * java.sql.Date.valueOf(searchDate); }
			 * 
			 * String searchEnbDate = request.getParameter("searchEndDate"); // 신원조회 끝나는 날짜
			 * java.sql.Date endDate = null; if (!searchEnbDate.equals("")) { endDate =
			 * java.sql.Date.valueOf(searchEnbDate); }
			 */
	         
			List<CleanerDTO> cleanerList = new CleanerService().searchCleanerInfomation(searchCondition, searchResult/* , date, endDate */);
	        String path = "";
	         if(cleanerList != null) {
	            path = "/WEB-INF/views/admin/cleaner/cleanerList.jsp";
	            request.setAttribute("cleanerList", cleanerList);
	         } else {
	            path = "/WEB-INF/views/common/failed.jsp";
	            request.setAttribute("message", "사용자 정보 조회 실패!");
	         }
	         
	         request.getRequestDispatcher(path).forward(request, response);
	    }
	    
	}

}
