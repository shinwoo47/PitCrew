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
		
		System.out.println(reqNo);
		
		RequestService requestService = new RequestService();
		RequestDTO req = requestService.checkRequestComplete(reqNo);		
		Date reqDate = req.getReqDate();
		System.out.println("reqDate : " + req.getReqDate());
		
		Date tomorrow = new Date(reqDate.getTime() + (1000 * 60 * 60 * 24));
		System.out.println("reqDate + 1 : " + tomorrow);
		
		Date now = new Date(System.currentTimeMillis());
		System.out.println("now : " + now);
		
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
