package com.pitcrew.cleanhome.cleaner.calcalate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.cleaner.calcalate.model.dto.CalculateDTO;
import com.pitcrew.cleanhome.cleaner.calcalate.model.service.CalculateService;


@WebServlet("/cleaner/calculate")
public class CalculateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CalculateService calculateService = new CalculateService();
		//CalculateDTO calculate = selectCalculate();
		
		String path = "/WEB-INF/views/cleaner/calculatelist.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
