package com.pitcrew.cleanhome.admin.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.notice.model.dto.NoticeDTO;
import com.pitcrew.cleanhome.admin.notice.model.service.NoticeService;


@WebServlet("/admin/notice/list")
public class SelectNoticeList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("controller 진입성공");
		
		List<NoticeDTO> noticeList = new NoticeService().selectAllNoticeList();
		
		System.out.println("controller : " + noticeList);
		
		String path = "";
		if(noticeList != null) {
			path = "/WEB-INF/views/admin/notice/noticeList.jsp";
			request.setAttribute("noticeList", noticeList);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "조회에 실패했습니다. 다시 시도해주세요.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
