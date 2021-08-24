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
		
		/* 카테고리 이름을 받아온다. */
		String category = request.getParameter("category");
		
		NoticeService noticeService = new NoticeService();
		
		/* 카테고리 이름에 맞는 게시글 목록 불러오기 메소드 */
		List<NoticeDTO> noticeList = noticeService.selectNoticeList(category);
		
		String path= "";
						
		if(noticeList != null) {
			path = "/WEB-INF/views/user/board/userNotice.jsp";
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("category", category);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시글 조회 실패");
		}
		request.getRequestDispatcher(path).forward(request, response);
	}


}
