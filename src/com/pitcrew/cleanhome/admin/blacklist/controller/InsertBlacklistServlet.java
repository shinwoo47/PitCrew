package com.pitcrew.cleanhome.admin.blacklist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.blacklist.model.dto.UserDTO;
import com.pitcrew.cleanhome.admin.blacklist.model.service.BlacklistService;

@WebServlet("/admin/blacklist/insert")
public class InsertBlacklistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/admin/blacklist/blacklistList.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		java.sql.Date enrollDate = java.sql.Date.valueOf(request.getParameter("enrollDate"));
		/* String memberRole = request.getParameter("memberRole"); */
		String memId = request.getParameter("memId");
		String memName = request.getParameter("memName");
		String phone = request.getParameter("phone");
		/*
		 * int penaltyScoreSum = Integer.parseInt(request.getParameter("penaltyScoreSum")); 
		 */
		String entYn = request.getParameter("entYn");
		
		System.out.println("송준일" + request.getParameter("memberRole"));
		System.out.println("memNo : " + memNo);
		
		UserDTO newBlacklist = new UserDTO();
		newBlacklist.setMemNo(memNo);
		newBlacklist.setEnrollDate(enrollDate);
		/* newBlacklist.setMemberRole(memberRole); */
		newBlacklist.setMemId(memId);
		newBlacklist.setMemName(memName);
		newBlacklist.setPhone(phone);
		/* newBlacklist.setPenaltyScoreSum(penaltyScoreSum); */
		newBlacklist.setEntYn(entYn);
		
		System.out.println("서블릿 : " + newBlacklist);
		 
		BlacklistService blacklistService = new BlacklistService();
		
		int result = blacklistService.insertBlacklist(newBlacklist);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/admin/blacklist/blacklistList.jsp";
			request.setAttribute("newBlacklist", newBlacklist);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "블랙리스트 추가에 실패하셨습니다.");
		}
	
		request.getRequestDispatcher(path).forward(request, response);
	}

}















