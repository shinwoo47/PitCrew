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

@WebServlet("/user/regist/request")
public class SelectMyRegistRequestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 세션에 저장된 로그인 정보를 가지고 온다.*/
		HttpSession session = request.getSession();
		
		/* 세션에 저장된 loginMember MemberDTO 타입으로 캐스팅*/
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		/* 로그인된 회원 번호를 변수에 초기화 한다.*/
		int memNoUser = loginMember.getMemNo();
		
		/* 등록한 의뢰 정보 조회*/
		List<UserRequestDTO> myRegistRequest = new MyReqService().myRegistRequest(memNoUser);
		 		
		String path = "";
		
		/* 성공 실패시 페이지 이동*/
		if(myRegistRequest != null) {
			path = "/WEB-INF/views/user/request/myRegistRequest.jsp";
			request.setAttribute("myRegistRequest", myRegistRequest);
			
		} else {
			path ="/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "의뢰 조회 실패하셨습니다 !!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}
