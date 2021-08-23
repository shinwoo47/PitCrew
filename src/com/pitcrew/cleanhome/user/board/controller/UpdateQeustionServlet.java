package com.pitcrew.cleanhome.user.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.user.board.model.dto.NoticeDTO;
import com.pitcrew.cleanhome.user.board.model.service.NoticeService;



@WebServlet("/user/notice/update")
public class UpdateQeustionServlet extends HttpServlet {	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		String path = "";
		path = "/WEB-INF/views/user/board//noticeUpdateForm.jsp";
		request.setAttribute("no", no);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int no = Integer.parseInt(request.getParameter("no"));		
		String title = request.getParameter("title");
		String content = request.getParameter("editordata");
		
		NoticeService noticeService = new NoticeService();
		
		NoticeDTO newNotice = new NoticeDTO();
		newNotice.setNo(no);
		newNotice.setTitle(title);
		newNotice.setContent(content);

		int result = noticeService.updateQuestion(newNotice);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "userupdateQuestion");				
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 수정에 실패하셨습니다.");
		}
	
		request.getRequestDispatcher(path).forward(request, response);
	}

}
