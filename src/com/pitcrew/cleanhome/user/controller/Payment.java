package com.pitcrew.cleanhome.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.user.model.dto.CleanDTO;
import com.pitcrew.cleanhome.user.model.service.CleanService;

@WebServlet("/user/clean/payment")
public class Payment extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**
		 * 결제 페이지로 값 전달 
		 */
		
		int optPrice = 5000;
		double optTime = 0.5;
		
		HttpSession session = request.getSession();
		CleanDTO clean = new CleanDTO();
		
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember"); 		/* 회원 번호 */
		
		/* 회원 번호에 해당하는 회원 정보 select */
		clean = new CleanService().selectMember(member);
		
		clean.setProPrice(Integer.parseInt(request.getParameter("CleanPrice")));	/* 가격 */
		clean.setTime(Double.parseDouble(request.getParameter("CleanTime")));		/* 청소시간 */
		clean.setProductNo(Integer.parseInt(request.getParameter("cleanNo")));		/* 청소 번호 */
		clean.setReqReq(request.getParameter("content"));							/* 요구사항 */
		String ta = request.getParameter("start");									/* 시작 일 */
		String tb = request.getParameter("startTime");								/* 시작 시간 */
		
		clean.setRewDate(ta +" " + tb);
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		try {
			
			/* 날짜 형식 지정 */
			clean.setReqDate(format2.parse(clean.getRewDate()));	
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/* 옵션1 선택시 가격, 시간 추가 */
		if(request.getParameter("optionNo1") != null)	 {
			clean.setOptionNo1(Integer.parseInt(request.getParameter("optionNo1")));
			clean.setProPrice(clean.getProPrice() + optPrice);
			clean.setTime(clean.getTime() + optTime);
		}
		
		/* 옵션2 선택시 가격, 시간 추가 */
		if(request.getParameter("optionNo2") != null)	 {
			clean.setOptionNo2(Integer.parseInt(request.getParameter("optionNo2")));
			clean.setProPrice(clean.getProPrice() + optPrice);
			clean.setTime(clean.getTime() + optTime);
		}
		
		/* 경로 설정 */
		String path = "/WEB-INF/views/user/request/payment.jsp";
		request.setAttribute("clean", clean);

		request.getRequestDispatcher(path).forward(request, response);
	}

}
