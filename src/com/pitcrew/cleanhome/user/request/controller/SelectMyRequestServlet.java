package com.pitcrew.cleanhome.user.request.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.user.request.model.dto.UserRequestDTO;
import com.pitcrew.cleanhome.user.request.model.service.MyReqService;

@WebServlet("/user/select/myRequest")
public class SelectMyRequestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		HttpSession session = request.getSession();
//		
//		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
//		
//		int memNo = loginMember.getMemNo();
//		
//		List<UserRequestDTO> selectMyAllReq = new MyReqService().selectMyAllReq(memNo);
		
		
		String path = "";
		
		path = "/WEB-INF/views/user/request/myRequest.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
