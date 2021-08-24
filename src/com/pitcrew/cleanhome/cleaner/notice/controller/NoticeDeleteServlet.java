package com.pitcrew.cleanhome.cleaner.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.cleaner.notice.model.service.NoticeService;


@WebServlet("/cleaner/notice/delete")
public class NoticeDeleteServlet extends HttpServlet {
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		/* 선택된 게시글 번호에 해당하는 게시글을 비활성화시키고 성공여부 반환*/
		NoticeService noticeService = new NoticeService();		
		int result = noticeService.deleteNotice(no);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "cleanerdeleteQuestion");				
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 삭제에 실패하셨습니다.");
		}
	
		request.getRequestDispatcher(path).forward(request, response);
	}

}
