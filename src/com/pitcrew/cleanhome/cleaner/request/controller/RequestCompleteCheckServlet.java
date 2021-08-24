package com.pitcrew.cleanhome.cleaner.request.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.cleaner.request.model.service.RequestService;


@WebServlet("/cleaner/request/complete/check")
public class RequestCompleteCheckServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reqNo = Integer.parseInt(request.getParameter("no"));
		
		/* 입력받은 의뢰 번호에 해당하는 의뢰의 일자를 반환*/
		RequestService requestService = new RequestService();
		RequestDTO req = requestService.checkRequestComplete(reqNo);		
		Date reqDate = req.getReqDate();
		
		/* 반환 받은 의뢰에 하루를 더함*/
		Date tomorrow = new Date(reqDate.getTime() + (1000 * 60 * 60 * 24));	
		
		/* 현재 날짜*/
		Date now = new Date(System.currentTimeMillis());
		
		/* 현재 날짜와 하루가 더해진 날짜를 비교하여 현재 날짜가 더 크지 않으면 0을 반환*/
		int result = 0;
		if(now.compareTo(tomorrow) > 0) {
			result = 1;
		}
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
		out.flush();
		out.close();

	}

	

}
