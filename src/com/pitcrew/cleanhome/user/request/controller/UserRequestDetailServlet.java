package com.pitcrew.cleanhome.user.request.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.user.request.model.dto.UserRequestDTO;
import com.pitcrew.cleanhome.user.request.model.service.MyReqService;

/**
 * Servlet implementation class UserRequestDetailServlet
 */
@WebServlet("/user/request/detail")
public class UserRequestDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
		
		UserRequestDTO userRequestDTO = new UserRequestDTO();
		userRequestDTO.setReqNo(no);
		userRequestDTO.setMemNoUser(member.getMemNo());
		
		UserRequestDTO requestDetail = new MyReqService().selectRequestDetail(userRequestDTO);
		
		System.out.println("requestDetail : " +  requestDetail);
		
		String path = "";
		
		if(requestDetail != null) {
			path = "/WEB-INF/views/user/request/requestDetail.jsp";
			request.setAttribute("requestDetail", requestDetail);
		} else {
			path = "/WEB-INF/views/common.failed.jsp";
			request.setAttribute("message", "의뢰상세 조회 실패!");
		}
			
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
