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

@WebServlet("/user/comp/regist/request")
public class CompleteMatchingReqServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		int memNoUser = loginMember.getMemNo();
		
		List<UserRequestDTO> compRegistReq = new MyReqService().compRegistReq(memNoUser);
		
		System.out.println("매칭된 의뢰 : " + compRegistReq);
		
		String path = "";
		
		if(compRegistReq != null) {
			path = "/WEB-INF/views/user/request/myCompMatchingRequest.jsp";
			request.setAttribute("compRegistReq", compRegistReq);
			
		} else {
			
			path ="/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "의뢰 조회 실패하셨습니다 !!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

}
