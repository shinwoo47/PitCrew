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
		
		/* 세션에 저장된 loginMember MemberDTO 타입으로 캐스팅*/
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember");			
		
		int memNo = member.getMemNo();
		String writer = member.getMemName();										
		String title = request.getParameter("title");								
		String content = request.getParameter("editordata");						
		
		NoticeService noticeService = new NoticeService();
		
		NoticeDTO newNotice = new NoticeDTO();
		
		newNotice.setWriter(writer);											/* 작성자 */
		newNotice.setTitle(title);												/* 제목 */
		newNotice.setContent(content);											/* 내용 */
		newNotice.setWriterMemberNo(memNo);										/* 회원번호 */
		newNotice.setForWho("사용자");
		
		/* 게시글 등록 메소드 */
		int result = noticeService.insertQeustion(newNotice);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "userinsertQuestion");				
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "문의사항 등록에 실패하셨습니다.");
		}
	
		request.getRequestDispatcher(path).forward(request, response);
	}

}
