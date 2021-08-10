package com.pitcrew.cleanhome.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.member.model.service.MemberService;



@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/login.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		
		System.out.println("memberId : " + memberId);
		System.out.println("memberPwd : " + memberPwd);
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(memberId);
		requestMember.setPwd(memberPwd);
		
		MemberService memberService = new MemberService();
		
		MemberDTO loginMember = memberService.loginCheck(requestMember);
		System.out.println(loginMember);
		
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			
			if(("해결사".equals(loginMember.getRole()))){
				request.setAttribute("successCode", "cleanerLogin");
				request.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(request, response);
			} else if(("관리자".equals(loginMember.getRole()))){
				request.setAttribute("successCode", "adminLogin");
				request.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(request, response);
			} else if(("사용자".equals(loginMember.getRole()))){
				request.setAttribute("successCode", "userLogin");
				request.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath());
			}
	
		} else {
			request.setAttribute("message", "로그인 실패!");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
		
	}

}
