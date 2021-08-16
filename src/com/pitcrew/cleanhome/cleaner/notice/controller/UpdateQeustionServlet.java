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


@WebServlet("/cleaner/notice/update")
public class UpdateQeustionServlet extends HttpServlet {	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		System.out.println("no : " + no);
		
		String path = "";
		path = "/WEB-INF/views/cleaner/noticeUpdateForm.jsp";
		request.setAttribute("no", no);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int no = Integer.parseInt(request.getParameter("no"));		
		String title = request.getParameter("title");
		String content = request.getParameter("editordata");
		
		
		System.out.println("게시판 컨트롤러  제목 체크 : " + title);
		System.out.println("게시판 컨트롤러  내용 체크 : " + content);
		
		NoticeService noticeService = new NoticeService();
		
		NoticeDTO newNotice = new NoticeDTO();
		newNotice.setNo(no);
		newNotice.setTitle(title);
		newNotice.setContent(content);

		int result = noticeService.updateQuestion(newNotice);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "cleanerupdateQuestion");				
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 수정에 실패하셨습니다.");
		}
	
		request.getRequestDispatcher(path).forward(request, response);
	}

}
