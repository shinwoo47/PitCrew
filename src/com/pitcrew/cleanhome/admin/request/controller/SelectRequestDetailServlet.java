package com.pitcrew.cleanhome.admin.request.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.admin.request.model.service.RequestService;

@WebServlet("/admin/request/detail")
public class SelectRequestDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reqNo = Integer.parseInt(request.getParameter("reqNo"));
		System.out.println("서블릿 도착 reqNo 받음 : " + reqNo);
		
		RequestDTO reqDetailDTO = new RequestService().selectReqHistory(reqNo);
		
		System.out.println("reqDetail controller : " + reqDetailDTO);
		
		String path = "";
		if(reqDetailDTO != null) {
			path = "/WEB-INF/views/admin/request/requestDetail.jsp";
			request.setAttribute("reqDetailDTO", reqDetailDTO);
		} else {
			path = "/WEB-INF/common/failed.jsp";
			request.setAttribute("message", "조회에 실패했습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}


}
