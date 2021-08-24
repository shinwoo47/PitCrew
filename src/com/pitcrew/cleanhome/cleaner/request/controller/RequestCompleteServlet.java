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


@WebServlet("/cleaner/request/complete")
public class RequestCompleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));                
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
		
		RequestDTO requestDto = new RequestDTO();
		requestDto.setReqNo(no);
		requestDto.setReqStatus("완료              ");
		requestDto.setMemNoCleaner(member.getMemNo());

		RequestService requestService = new RequestService();
		
		/* 선택한 의뢰를 완료상태로 변경후 성공 여부를 반환*/
		int result = requestService.completeRequest(requestDto);                           
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "completeRequest");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "의뢰 완료 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
}
