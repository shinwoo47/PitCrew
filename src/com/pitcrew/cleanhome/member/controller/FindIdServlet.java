package com.pitcrew.cleanhome.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.member.model.service.MemberService;

@WebServlet("/member/findId")
public class FindIdServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/findId.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memName = request.getParameter("memName");
		String email = request.getParameter("email");
		
		MemberDTO findMyId = new MemberDTO();
		findMyId.setMemName(memName);
		findMyId.setEmail(email);
		
		
		/*아이디 비밀번호 찾기 폼에서 입력한 값 */
		System.out.println("findMyId : " + findMyId);
		
		/* 아이디 불러온 값*/
		MemberDTO selectMyId = new MemberService().selectMyId(findMyId);
		
		System.out.println("selectMyId : " + selectMyId);
		
		String path = "";
		
		if(selectMyId != null) {
			path = "/WEB-INF/views/member/successFindId.jsp";

			request.setAttribute("selectMyId", selectMyId);
			
		} else {
			request.setAttribute("message", "정보조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
