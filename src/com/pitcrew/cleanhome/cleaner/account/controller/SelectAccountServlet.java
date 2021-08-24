package com.pitcrew.cleanhome.cleaner.account.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.cleaner.account.model.service.AccountService;
import com.pitcrew.cleanhome.member.model.dto.CleanerInfoDTO;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;


@WebServlet("/cleaner/account")
public class SelectAccountServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
		
		AccountService accountService = new AccountService();
		
		/* 로그인한 회원의 회원번호와 일치하는 해결사 추가 정보 조회*/
		CleanerInfoDTO cleanerInfo = accountService.selectCleanerInfo(member.getMemNo());
		
		String path = "/WEB-INF/views/cleaner/accountlist.jsp";	
		request.setAttribute("member", member);
		request.setAttribute("account", cleanerInfo);
	
		request.getRequestDispatcher(path).forward(request, response);
	}

}
