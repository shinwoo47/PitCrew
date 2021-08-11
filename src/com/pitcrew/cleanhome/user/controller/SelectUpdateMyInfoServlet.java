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
		
		HttpSession session = request.getSession();
		
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		int memNo = loginMember.getMemNo();
		
		List<MemberDTO> selectUpdateMyInfo = new MyInfoService().selectUpdateMyInfo(memNo);
		
		System.out.println("selectUpdateMyInfo : " + selectUpdateMyInfo );
		
		String path = "";
		if(selectUpdateMyInfo != null) {
			path = "/WEB-INF/views/user/selectUpdateMyInfo.jsp";
			request.setAttribute("selectUpdateMyInfo", selectUpdateMyInfo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원정보 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

}
