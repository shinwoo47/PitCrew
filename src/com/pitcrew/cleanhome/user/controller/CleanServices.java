package com.pitcrew.cleanhome.user.controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user/clean/services")
public class CleanServices extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		String path = "/WEB-INF/views/user/request/cleaningScope.jsp";
				
		request.getRequestDispatcher(path).forward(request, response);
	}


}
