package com.pitcrew.cleanhome.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.user.model.dto.CleanDTO;
import com.pitcrew.cleanhome.user.model.service.SelectCleanService;

@WebServlet("/clean/list")
public class SelectCleanIntroductionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		
		String path = "";
		if(clean != null) {
			path = "/WEB-INF/views/user/information.jsp";
			request.setAttribute("clean", clean);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "서비스이동실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}


}
