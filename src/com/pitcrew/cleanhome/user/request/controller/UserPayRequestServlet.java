package com.pitcrew.cleanhome.user.request.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.user.model.dto.CleanDTO;
import com.pitcrew.cleanhome.user.request.model.dto.UserRequestDTO;
import com.pitcrew.cleanhome.user.request.model.service.MyReqService;

@WebServlet("/user/pay/request")
public class UserPayRequestServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
//		int memNoUser = loginMember.getMemNo();
		String reqNo = request.getParameter("reqNo");
		int serPrice = Integer.parseInt(request.getParameter("serPrice"));
		Date reqDate = Date.valueOf(request.getParameter("reqDate"));
		int productNo = Integer.parseInt(request.getParameter("reqOptionNo"));
		int optionNo1 = Integer.parseInt(request.getParameter("reqOptionNo1"));
		int optionNo2 = Integer.parseInt(request.getParameter("reqOptionNo2"));
		
		System.out.println("reqNo");
		
		CleanDTO payReqInfo = new CleanDTO();
		payReqInfo.setMemNoUser(loginMember.getMemNo());
//		payReqInfo.setReqNo(reqNo);
		payReqInfo.setProPrice(serPrice);
		payReqInfo.setReqDate(reqDate);
		payReqInfo.setProductNo(productNo);
		payReqInfo.setOptionNo1(optionNo1);
		payReqInfo.setOptionNo2(optionNo2);
		
		System.out.println("payReqInfo : " + payReqInfo);
		
		
//		int result = new MyReqService().payRequest(payReqInfo);
		
		String path = "";
		if(payReqInfo != null) {
			path = "/WEB-INF/views/user/services.jsp";
			
		} else {
			System.out.println("에러 ㅋ");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
		
		
//		int memNoUser = loginMember.getMemNo();
//		int reqNo = Integer.parseInt(request.getParameter("reqNo"));
//		int serPrice = Integer.parseInt(request.getParameter("serPrice"));
//		Date reqDate = Date.valueOf(request.getParameter("reqDate"));
//		
//		CleanDTO payReqInfo = new CleanDTO();
//		
		
		
		
		
		
		
		
		
	}

}
