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
		
		/*아이디 찾기 페이지로 이동한다.*/
		String path = "/WEB-INF/views/member/findId.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 아이디 찾기 시 입력했던 이름과 이메일을 입력 후 
		 * 그 파라미터 값을 변수에 초기화 시켜준 후 
		 * 인자값을 DAO.xml로 전달한 후
		 * DAO.xml에서 조회한 값이 null값이 아니면 
		 * 아이디 찾기 성공 페이지로 이동한다.
		 * */
		
		/* 아이디 찾기 폼에서 입력한 파라미터를 변수에 담아준다.*/
		String memName = request.getParameter("memName");
		String email = request.getParameter("email");
		
		/* 초기화 한 변수를 MemberDTO 타입에 set메소드를 이용해 값을 담아준다.*/
		MemberDTO findMyId = new MemberDTO();
		findMyId.setMemName(memName);
		findMyId.setEmail(email);
		
		/* findMyId에 담아준 값을 인자값으로 전달 후 db에서 입력한 회원 아이디를 조회한다.*/
		MemberDTO selectMyId = new MemberService().selectMyId(findMyId);
		
		/* 경로 설정 */
		String path = "";
		
		if(selectMyId != null) {
			
			/* null값이 아닐 때 이동하는 페이지 */
			path = "/WEB-INF/views/member/successFindId.jsp";
			request.setAttribute("selectMyId", selectMyId);
			
		} else {
			
			/* null값일 때 이동하는 페이지 */
			path = "/WEB-INF/views/common/failedInput.jsp";
			request.setAttribute("message", "아이디 찾기 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
