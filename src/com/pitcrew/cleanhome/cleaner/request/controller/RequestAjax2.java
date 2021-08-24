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
		String FormDate = "";
		Date date3;

		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("memNoCleaner",cleanerMemNo);
		
		/* 로그인 세션의 회원 번호에 해당하는 모든 의뢰 내역을 리스트로 반환*/
		RequestService requestService = new RequestService();
		List <FullCalendarDTO> calendarList = requestService.selectCalendar(searchMap);     
		
		/* 반환된 리스트에서 의뢰 상태에 따라 색깔을 지정하여 의뢰 상태를 구분*/
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
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(jsonString);
		
		out.flush();
		out.close();
	}

}
