package com.pitcrew.cleanhome.cleaner.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.cleaner.notice.model.dto.NoticeDTO;
import com.pitcrew.cleanhome.cleaner.notice.model.service.NoticeService;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;


@WebServlet("/cleaner/notice/list")
public class NoticeSelectList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String category = request.getParameter("category");
		System.out.println("category : " + category);
		
		NoticeService noticeService = new NoticeService();
		List<NoticeDTO> noticeList = noticeService.selectNoticeList(category);
		
		System.out.println(noticeList);
		
		String path= "";
		if(noticeList != null) {
			path = "/WEB-INF/views/cleaner/noticeList.jsp";
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("category", category);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
