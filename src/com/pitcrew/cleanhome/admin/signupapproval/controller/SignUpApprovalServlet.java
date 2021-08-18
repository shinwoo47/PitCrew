package com.pitcrew.cleanhome.admin.signupapproval.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.signupapproval.model.dto.SignUpApprovalDTO;
import com.pitcrew.cleanhome.admin.signupapproval.model.service.SignUpApprovalService;
import com.pitcrew.cleanhome.member.model.dto.CleanerInfoDTO;

@WebServlet("/admin/signup/approval")
public class SignUpApprovalServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int memNo = Integer.parseInt(request.getParameter("memNo"));
		String identifyYn = request.getParameter("identifyYn");
		String educateYn = request.getParameter("educateYn");
		
		SignUpApprovalDTO cleanerInfo = new SignUpApprovalDTO();
		cleanerInfo.setMemNo(memNo);
		cleanerInfo.setIdentifyYn(identifyYn);
		cleanerInfo.setEducateYn(educateYn);
		
		System.out.println(identifyYn);
		System.out.println(educateYn);
		
		SignUpApprovalService signUpApprovalService = new SignUpApprovalService();
		
		int result = signUpApprovalService.SignUpApproval(cleanerInfo);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/admin/signupapproval/signupapproval.jsp";
			request.setAttribute("cleanerInfo", cleanerInfo);				
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "상품 수정에 실패하셨습니다.");
		}
	
		request.getRequestDispatcher(path).forward(request, response);
	}

}










