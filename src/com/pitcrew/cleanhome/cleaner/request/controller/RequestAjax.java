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
import com.pitcrew.cleanhome.cleaner.request.model.dto.FullCalendarDTO;
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
		
		String requestStatus = request.getParameter("status");
		if(requestStatus == null) {
			requestStatus = "매칭              ";
		}
		
		String cleanerMemNo = String.valueOf(memNo);	
		String date = (request.getParameter("date"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date2;
		String searchDate = null;
		try {
			date2 = simpleDateFormat.parse(date);
			searchDate = simpleDateFormat.format(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		/* 전달받은 의뢰 일자와 의뢰 상태, 로그인 세션의 회원번호를 맵에 저장*/
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchDate", searchDate);
		searchMap.put("reqStatus", requestStatus);
		searchMap.put("memNoCleaner",cleanerMemNo);

		RequestService requestService = new RequestService();
		
		/* 맵을 이용하여 해당하는 의뢰 리스트를 반환*/
		List<RequestDTO> requestList = requestService.selectCleanerRequestList(searchMap);
		
		String jsonString = new Gson().toJson(requestList);
		
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
