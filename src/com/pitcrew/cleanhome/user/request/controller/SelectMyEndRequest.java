package com.pitcrew.cleanhome.user.request.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/end/request")
public class SelectMyEndRequest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/user/request/paymentProceed.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
