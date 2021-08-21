package com.pitcrew.cleanhome.user.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.user.board.model.dto.NoticeDTO;
import com.pitcrew.cleanhome.user.board.model.service.NoticeService;


@WebServlet("/user/notice/insert")
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
		System.out.println("writer : " + writer);
		
		String title = request.getParameter("title");
		String content = request.getParameter("editordata");
		
		
		System.out.println("게시판 컨트롤러  제목 체크 : " + title);
		System.out.println("게시판 컨트롤러  내용 체크 : " + content);
		
		NoticeService noticeService = new NoticeService();
		
		NoticeDTO newNotice = new NoticeDTO();
		newNotice.setTitle(title);
		newNotice.setContent(content);
		newNotice.setWriterMemberNo(memNo);
		newNotice.setWriter(writer);
		newNotice.setForWho("사용자");
		int result = noticeService.insertQeustion(newNotice);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "userinsertQuestion");				
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 등록에 실패하셨습니다.");
		}
	
		request.getRequestDispatcher(path).forward(request, response);
	}

}
