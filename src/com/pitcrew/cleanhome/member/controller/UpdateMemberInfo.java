package com.pitcrew.cleanhome.member.controller;

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


@WebServlet("/cleaner/member/update")
public class UpdateMemberInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session = request.getSession();

		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		int memNo = loginMember.getMemNo();
			
		List<MemberDTO> selectMyInfo = new MyInfoService().selectMyInfo(memNo);
		
		String path = "/WEB-INF/views/cleaner/updatemyinfoForm.jsp";
		request.setAttribute("selectUpdateMyInfo", selectMyInfo);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		int memNo = loginMember.getMemNo();
		String pwd = request.getParameter("memberPwd");
		String address = request.getParameter("zipCode") + "$" + request.getParameter("address1") + "$" + request.getParameter("address2");
		String email = request.getParameter("updateEmail");
		
		MemberDTO updateMember = new MemberDTO();
		updateMember.setMemNo(memNo);
		updateMember.setPwd(pwd);
		updateMember.setAddress(address);
		updateMember.setEmail(email);
				
		int result = new MyInfoService().updateMyInfo(updateMember);
		
		String page = "";
		
		if(result > 0) {
			
			page = "/WEB-INF/views/common/success.jsp";
			
			request.setAttribute("successCode", "updateCleanerInfo");
			
		} else {
			
			page = "/WEB-INF/views/common/failed.jsp";
			
			request.setAttribute("message", "회원정보 실패!");
			
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	
	}

}
