package com.pitcrew.cleanhome.cleaner.request.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
		String requestStatus = "매칭              ";
		String cleanerMemNo = String.valueOf(memNo);
		
		String date = (request.getParameter("date"));
		System.out.println("searchDate : " + date);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date2;
		String searchDate = null;
		try {
			date2 = simpleDateFormat.parse(date);
			searchDate = simpleDateFormat.format(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("serachDate : " + searchDate);
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchDate", searchDate);
		searchMap.put("reqStatus", requestStatus);
		searchMap.put("memNoCleaner",cleanerMemNo);
		
		/* 전체 게시물 수가 필요하다.
		 * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
		 * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
		 * */
		RequestService requestService = new RequestService();
		int totalCount = requestService.selectCleanerTotalCount(searchMap);
		
		System.out.println("totalBoardCount : " + totalCount);

		
		/* 조회해온다 */
		List<RequestDTO> requestList = requestService.selectCleanerRequestList(searchMap);
		System.out.println("requestList : " + requestList);

		String jsonString = new Gson().toJson(requestList);
		
		System.out.println(jsonString);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(jsonString);
		
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
