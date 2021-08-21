package com.pitcrew.cleanhome.admin.blacklist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.blacklist.model.service.BlacklistService;

@WebServlet("/admin/blacklist/delete")
public class DeleteBlacklist extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블리리리릿");
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		BlacklistService blacklistService = new BlacklistService();
		
		int result = blacklistService.deleteBlacklist(memNo);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "deleteBlacklist");
			response.setHeader("Refresh","300");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "블랙리스트 삭제에 실패하셨습니다.");
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}











