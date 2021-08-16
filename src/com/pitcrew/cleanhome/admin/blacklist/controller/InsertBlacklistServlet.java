package com.pitcrew.cleanhome.admin.blacklist.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.blacklist.model.dto.UserDTO;

@WebServlet("/admin/blacklist/insert")
public class InsertBlacklistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "/WEB-INF/views/admin/blacklist/blacklistList.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		String birth = request.getParameter("birth");
		String memberRole = request.getParameter("memberRole");
		String memId = request.getParameter("memId");
		String memName = request.getParameter("memName");
		String phone = request.getParameter("phone");
		int penaltyScoreSum = Integer.parseInt(request.getParameter("penaltyScoreSum"));
		String entYn = request.getParameter("entYn");
		
		UserDTO newBlacklist = new UserDTO();
		newBlacklist.setMemNo(memNo);
		newBlacklist.setMemName(memName);
		newBlacklist.setMemId(memId);
//		newBlacklist.setBirth(birth);
		
	}

}















