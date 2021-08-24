package com.pitcrew.cleanhome.cleaner.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.cleaner.notice.model.dto.NoticeDTO;
import com.pitcrew.cleanhome.cleaner.notice.model.service.NoticeService;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;


@WebServlet("/cleaner/notice/insert")
public class InsertQuestionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path="/WEB-INF/views/user/board/noticeinsertForm.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
		int memNo = member.getMemNo();
		String writer = member.getMemName();		
		String title = request.getParameter("title");
		String content = request.getParameter("editordata");
		
		/* 입력한 값들을 dto에 담기*/
		NoticeDTO newNotice = new NoticeDTO();
		newNotice.setTitle(title);
		newNotice.setContent(content);
		newNotice.setWriterMemberNo(memNo);
		newNotice.setWriter(writer);
		newNotice.setForWho("해결사");
		
		/* 입력한 값들이 담긴 dto를 이용하여 db에 insert한후 결과를 반환*/
		NoticeService noticeService = new NoticeService();
		int result = noticeService.insertQeustion(newNotice);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "cleanerinsertQuestion");				
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 등록에 실패하셨습니다.");
		}
	
		request.getRequestDispatcher(path).forward(request, response);
	}

}
