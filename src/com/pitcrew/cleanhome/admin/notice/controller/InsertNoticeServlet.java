package com.pitcrew.cleanhome.admin.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.admin.notice.model.dto.NoticeDTO;
import com.pitcrew.cleanhome.admin.notice.model.service.NoticeService;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;

@WebServlet("/admin/notice/insert")
public class InsertNoticeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/admin/notice/insertForm.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("editordata");
		String forWho = request.getParameterValues("forWho")[0];
		
		
		System.out.println("게시판 컨트롤러  제목 체크 : " + title);
		System.out.println("게시판 컨트롤러  내용 체크 : " + content);
		System.out.println("게시판 컨트롤러  대상 체크 : " + forWho);
		
		NoticeService noticeService = new NoticeService();
		int adminNo = noticeService.selectMemberNo();
		System.out.println("관리자 회원번호 : " + adminNo);
		
		NoticeDTO newNotice = new NoticeDTO();
		newNotice.setTitle(title);
		newNotice.setContent(content);
		newNotice.setForWho(forWho);
		newNotice.setWriterMemberNo(adminNo);
		
		int result = noticeService.insertNotice(newNotice);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/admin/notice/noticeList.jsp";
			request.setAttribute("successCode", "insertNotice");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 등록에 실패하셨습니다.");
		}
	
		request.getRequestDispatcher(path).forward(request, response);
	}

}
