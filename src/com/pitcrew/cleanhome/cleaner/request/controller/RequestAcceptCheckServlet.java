package com.pitcrew.cleanhome.cleaner.request.controller;

import java.io.IOException;
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
		
		RequestService requestService = new RequestService();
		List<RequestDTO> requestList = requestService.requestAcceptCheck(member);
		
		String stringDate = (request.getParameter("date"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date reqDate = new Date();		
		try {
			reqDate = format.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int result = 0;
		for(int i = 0; i < requestList.size(); i++) {
			System.out.println(requestList.get(i).getReqDate());
			if((reqDate.getTime() - requestList.get(i).getReqDate().getTime()) / (60 * 60 * 1000) < 6) {
				result = 1;
				break;
			}
		}
		System.out.println("result : " + result);
	}


}
