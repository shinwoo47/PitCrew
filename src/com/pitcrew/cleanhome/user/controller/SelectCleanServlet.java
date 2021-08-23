package com.pitcrew.cleanhome.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.user.model.dto.CleanDTO;

@WebServlet("/user/clean/select")
public class SelectCleanServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		CleanDTO clean = new CleanDTO();
		int number = Integer.parseInt(request.getParameter("number")); 
		if(number ==1) { 
			clean.setImgNo("roomClean.png");
			clean.setName("방청소");
			clean.setPrice(25000);
			clean.setTime(2);
			clean.setCleanNo(1);
		} else if(number == 2) {
			clean.setImgNo("bathroomClean.png");
			clean.setName("화장실");
			clean.setPrice(30000);
			clean.setTime(2);
			clean.setCleanNo(2);
		} else if(number == 3) { 
			clean.setImgNo("allClean.png");
			clean.setName("전체청소");
			clean.setPrice(55000);
			clean.setTime(5);
			clean.setCleanNo(3);
		}	
		String path = "";
		if (number > 0) {
			path = "/WEB-INF/views/user/request/selectcleaning.jsp";
			request.setAttribute("clean", clean);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "청소 조회 실패");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

}
