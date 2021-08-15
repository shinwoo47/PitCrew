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

@WebServlet("/admin/cleanerfaq/list")
public class SelectFaqCleanerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("controller 진입성공");

		String forWho = "해결사";
		List<NoticeDTO> faqCleanerList = new NoticeService().selectAllFaqList(forWho);

		System.out.println("controller : " + faqCleanerList);


		String path = "";
		if(faqCleanerList != null) {
			path = "/WEB-INF/views/admin/notice/faqCleanerList.jsp";
			request.setAttribute("faqCleanerList", faqCleanerList);
		} else {
			path = "/WEB-INF/common/failed.jsp";
			request.setAttribute("message", "조회에 실패했습니다.");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}




}
