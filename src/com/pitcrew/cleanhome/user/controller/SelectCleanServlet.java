package com.pitcrew.cleanhome.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.user.model.dto.CleanDTO;
import com.pitcrew.cleanhome.user.model.service.SelectCleanService;

@WebServlet("/clean/select/")
public class SelectCleanServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int number = Integer.parseInt(request.getParameter("number"));
		if(number == 1) {
			//서비스이동
			List<CleanDTO> cleanlist = new SelectCleanService().Cleaninformation();
		} else if(number == 2) {
			
		} else if(number == 3) {
			
		}
		String path = "";
		if(clean != null) {
			path = "/WEB-INF/views/user/selectcleaning.jsp";
			request.setAttribute("clean", clean);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "청소 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}


}
