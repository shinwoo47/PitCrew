package com.pitcrew.cleanhome.cleaner.request.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.cleaner.request.model.service.RequestService;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;



@WebServlet("/cleaner/request/detail")
public class RequestDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int no = Integer.parseInt(request.getParameter("no"));                 //의뢰 번호
		String status = request.getParameter("status");                        //의뢰 상태
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
		
		
		
		RequestDTO requestDto = new RequestDTO();
		requestDto.setReqNo(no);
		requestDto.setReqStatus(status);
		requestDto.setMemNoCleaner(member.getMemNo());
		
		RequestService requestService = new RequestService();
		
		RequestDTO requestDetail = requestService.selectRequestDetail(requestDto);  //매칭된 의뢰 상세 조회
		System.out.println("requestDetail : " + requestDetail);     
		
		String path = "";
		if(requestDetail != null) {
			//의뢰 상세조회 성공
			path = "/WEB-INF/views/cleaner/requestDetails.jsp";               
			request.setAttribute("requestDetail", requestDetail);
		} else {
			//의뢰 상세조회 실패
			path = "/WEB-INF/views/common.failed.jsp";
			request.setAttribute("message", "의뢰 상세 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
