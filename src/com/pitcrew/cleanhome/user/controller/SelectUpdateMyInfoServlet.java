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

@WebServlet("/user/select/update/myInfo")
public class SelectUpdateMyInfoServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 세션에 저장된 로그인 정보를 가지고 온다.*/
		HttpSession session = request.getSession();
		
		/* 세션에 저장된 loginMember MemberDTO 타입으로 캐스팅*/
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		int memNo = loginMember.getMemNo();
		
		/* 회원정보를 수정하기 위해 필요한 유저 정보를 리스트로 담고 호출*/
		List<MemberDTO> selectUpdateMyInfo = new MyInfoService().selectUpdateMyInfo(memNo);
		
		System.out.println("selectUpdateMyInfo : " + selectUpdateMyInfo );
		
		
		String path = "";
		if(selectUpdateMyInfo != null) {
			path = "/WEB-INF/views/user/member/selectUpdateMyInfo.jsp";
			request.setAttribute("selectUpdateMyInfo", selectUpdateMyInfo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원정보 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

}
