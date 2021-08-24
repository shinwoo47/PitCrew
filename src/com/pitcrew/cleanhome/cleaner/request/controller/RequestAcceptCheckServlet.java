package com.pitcrew.cleanhome.cleaner.request.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.cleaner.request.model.service.RequestService;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;


@WebServlet("/cleaner/request/accept/check")
public class RequestAcceptCheckServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
		
		/* 로그인 세션을 이용하여 매칭된 모든 의뢰를 리스트로 반환*/
		RequestService requestService = new RequestService();
		List<RequestDTO> requestList = requestService.requestAcceptCheck(member);
		
		String stringDate = (request.getParameter("date"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd(E)hh시");
		Date reqDate = new Date();		
		try {
			reqDate = format.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/* 반환받은 리스트에서 현재 시간과 6시간이내에 해당하는 의뢰가 있으면 1을 반환*/
		int result = 0;
		for(int i = 0; i < requestList.size(); i++) {
			if(Math.abs(reqDate.getTime() - requestList.get(i).getReqDate().getTime()) / (60 * 60 * 1000) < 6) {   							
				result = 1;
				break;
			}
		}
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
		out.flush();
		out.close();
	}


}
