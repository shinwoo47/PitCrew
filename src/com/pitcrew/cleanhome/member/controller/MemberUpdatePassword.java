package com.pitcrew.cleanhome.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.member.model.service.MemberService;

@WebServlet("/member/update/password")
public class MemberUpdatePassword extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/retypePwd.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 인증키와 아까 넣어둔 세션의 값을 비교해서 맞지않으면 다른곳으로 보내고 맞으면 비밀번호 변경 로직 작성*/
		String id = request.getParameter("memId");
		String pwd = request.getParameter("memberPwd");
		String AuthenticationKey = (String)request.getSession().getAttribute("AuthenticationKey");
		String certificationNum = request.getParameter("certificationNum");

		String path = "";
		
		/* 인증키와 넣어둔 세션의 값이 일치하지 않을시 다시 비밀번호 수정jsp로 넘어감*/
		if(!AuthenticationKey.equals(certificationNum)) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "inconsistentCertifiNum");
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			
			/* 인증번호가 맞을 때의 로직*/
			MemberDTO updatePwd = new MemberDTO();
			updatePwd.setId(id);
			updatePwd.setPwd(pwd);
			
			/* MemberDTO에 담아준 id와 pwd를 인자로 넘겨서 업데이트*/
			int result = new MemberService().updateMemberPwd(updatePwd);
			
			System.out.println("result : " + result);
			
			
			if(result > 0) {
				path = "/WEB-INF/views/common/success.jsp";
				request.setAttribute("successCode", "updatePwd");
				
			} else {
				path = "/WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "비밀번호 변경 실패!");
			}
			
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}

}
