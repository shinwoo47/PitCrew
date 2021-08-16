package com.pitcrew.cleanhome.cleaner.request.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;


@WebServlet("/cleaner/request/ajax2")
public class RequestAjax2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		MemberDTO member =((MemberDTO) session.getAttribute("loginMember"));
		int memNo = member.getMemNo();
		String cleanerMemNo = String.valueOf(memNo);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("memNoCleaner",cleanerMemNo);
		
		/* 전체 게시물 수가 필요하다.
		 * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
		 * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
		 * */
		RequestService requestService = new RequestService();

		String FormDate = "";
		Date date3;
		
		List <FullCalendarDTO> calendarList = requestService.selectCalendar(searchMap);     //캘린더에 추가할 일정 조회
		
		for(int i = 0; i < calendarList.size(); i++) {
			try {
				date3 = format.parse(calendarList.get(i).getStart());
				FormDate = format.format(date3);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			calendarList.get(i).setStart(FormDate);
			if(calendarList.get(i).getBackgroundColor().equals("매칭              ")) {
				calendarList.get(i).setBackgroundColor("blue");
			} else if(calendarList.get(i).getBackgroundColor().equals("완료              ")) {
				calendarList.get(i).setBackgroundColor("green");
			} else if(calendarList.get(i).getBackgroundColor().equals("수정              ")) {
				calendarList.get(i).setBackgroundColor("red");
			}
		}
		
		String jsonString = new Gson().toJson(calendarList);
		
		System.out.println(jsonString);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(jsonString);
		
		out.flush();
		out.close();
	}

}
