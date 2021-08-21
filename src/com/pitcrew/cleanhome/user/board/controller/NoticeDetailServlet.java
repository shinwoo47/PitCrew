package com.pitcrew.cleanhome.user.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.user.board.model.dto.NoticeDTO;
import com.pitcrew.cleanhome.user.board.model.service.NoticeService;



@WebServlet("/user/notice/detail")
public class NoticeDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		System.out.println(no);
		
		NoticeService noticeService = new NoticeService();
		NoticeDTO noticeDetail = noticeService.selectNoticeDetail(no);
		
		
		System.out.println("noticeDeatil :" + noticeDetail);
		
		String path = "";
		if(noticeDetail != null) {
			String category = noticeDetail.getCategory();
			path = "/WEB-INF/views/user/board/noticeDetail.jsp";
			request.setAttribute("noticeDTO", noticeDetail);
			request.setAttribute("category", category);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	

}
