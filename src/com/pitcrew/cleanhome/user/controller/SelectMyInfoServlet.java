package com.pitcrew.cleanhome.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.user.model.service.MyInfoService;

@WebServlet("/user/select/myInfo")
public class SelectMyInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/* 세션에 저장된 로그인 정보를 가지고 온다.*/ 
		HttpSession session = request.getSession();
		
		/* 세션에 저장된 loginMember MemberDTO 타입으로 캐스팅*/
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		/* 로그인된 회원 번호를 변수에 초기화 한다.*/
		int memNo = loginMember.getMemNo();
			
		/* 회원 정보를 조회하기 위한 리스트를 만든다.*/
		List<MemberDTO> selectMyInfo = new MyInfoService().selectMyInfo(memNo);
		
		/* 리스트가 null값이 아니면 if문에 있는 jsp로 이동*/
		String path = "";
		if(selectMyInfo != null) {
			path = "/WEB-INF/views/user/selectMyInfo.jsp";
			request.setAttribute("selectMyInfo", selectMyInfo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원정보 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	
	}


}
