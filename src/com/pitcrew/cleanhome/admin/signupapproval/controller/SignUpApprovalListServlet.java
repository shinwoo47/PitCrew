package com.pitcrew.cleanhome.admin.signupapproval.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.signupapproval.model.dto.SignUpApprovalDTO;
import com.pitcrew.cleanhome.admin.signupapproval.model.service.SignUpApprovalService;

@WebServlet("/admin/signup/list")
public class SignUpApprovalListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<SignUpApprovalDTO> signUpList = new SignUpApprovalService().selectAllSignUpList();
		
		
		String path = "";
		if(signUpList != null) {
			path = "/WEB-INF/views/admin/signupapproval/signUpApproval.jsp";
			request.setAttribute("signUpList", signUpList);				
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "가입 승인 리스트 조회에 실패하셨습니다.");
		}
	
		request.getRequestDispatcher(path).forward(request, response);
	}

}
