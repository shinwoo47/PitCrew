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
		int no = Integer.parseInt(request.getParameter("no"));                 //의뢰 번호                      //의뢰 상태
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
		
		RequestDTO requestDto = new RequestDTO();
		requestDto.setReqNo(no);
		requestDto.setReqStatus("완료              ");
		requestDto.setMemNoCleaner(member.getMemNo());

		RequestService requestService = new RequestService();

		int result = requestService.completeRequest(requestDto);                           //의뢰 매칭(의뢰해결사등록)(의뢰 상태 '매칭'으로 변경)(의뢰 히스토리 내역 입력)
		
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
