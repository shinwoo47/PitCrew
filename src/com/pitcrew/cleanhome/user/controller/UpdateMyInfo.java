package com.pitcrew.cleanhome.user.controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.user.model.service.MyInfoService;

@WebServlet("/user/update/myInfo")
public class UpdateMyInfo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		int memNo = loginMember.getMemNo();
		String pwd = request.getParameter("newPwd");
		String address = request.getParameter("zipCode") + "$" + request.getParameter("address1") + "$" + request.getParameter("address2");
		String email = request.getParameter("updateEmail");
		
		MemberDTO updateMember = new MemberDTO();
		updateMember.setMemNo(memNo);
		updateMember.setPwd(pwd);
		updateMember.setAddress(address);
		updateMember.setEmail(email);
		
		System.out.println("updateMember : " + updateMember);
		
		int result = new MyInfoService().updateMyInfo(updateMember);
		
		System.out.println("result : " + result);
		
		String page = "";
		
		if(result > 0) {
			
			page = "/WEB-INF/views/common/success.jsp";
			
			request.setAttribute("successCode", "updateUserInfo");
			
		} else {
			
			page = "/WEB-INF/views/common/failed.jsp";
			
			request.setAttribute("message", "회원정보 실패!");
			
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	
	}

}
