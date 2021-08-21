package com.pitcrew.cleanhome.user.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.user.board.model.dto.NoticeDTO;
import com.pitcrew.cleanhome.user.board.model.service.NoticeService;



@WebServlet("/user/board/notice")
public class NoticeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String category = request.getParameter("category");
		System.out.println("category : " + category);
		NoticeService noticeService = new NoticeService();
		List<NoticeDTO> noticeList = noticeService.selectNoticeList(category);
		
		System.out.println("noticeList : "  +noticeList);
		
		String path= "";
						
		if(noticeList != null) {
			path = "/WEB-INF/views/user/board/userNotice.jsp";
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("category", category);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 조회 실패");
		}
		request.getRequestDispatcher(path).forward(request, response);
	}


}
