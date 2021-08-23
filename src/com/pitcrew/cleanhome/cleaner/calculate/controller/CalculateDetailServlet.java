package com.pitcrew.cleanhome.cleaner.calculate.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.cleaner.calculate.model.dto.CalculateByRequestDTO;
import com.pitcrew.cleanhome.cleaner.calculate.model.service.CalculateService;


@WebServlet("/cleaner/calculate/detail")
public class CalculateDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int calNo = Integer.parseInt(request.getParameter("no"));
		
		
		CalculateService calculateService = new CalculateService();
		
		List<CalculateByRequestDTO> calculateList = calculateService.selectCalculateDetail(calNo);
		
		
		String path = "";
		if(calculateList != null) {
			path = "/WEB-INF/views/cleaner/calculateDetail.jsp";
			request.setAttribute("calculateList", calculateList);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "정산 상세조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
