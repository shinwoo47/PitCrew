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

@WebServlet("/user/request/detail")
public class UserRequestDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*int no;는  상세 보기를 하기 위한 의뢰 번호 */
		int no = Integer.parseInt(request.getParameter("no"));
		
		/* 세션에 저장된 로그인 정보를 가지고 온다.*/
		HttpSession session = request.getSession();
		
		/* 세션에 저장된 loginMember MemberDTO 타입으로 캐스팅*/
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
		
		/* 상세보기 조회를 위해 dto에 값 초기화*/
		UserRequestDTO userRequestDTO = new UserRequestDTO();
		userRequestDTO.setReqNo(no);
		userRequestDTO.setMemNoUser(member.getMemNo());
		
		/* 의뢰 상세보기를 위한 정보 조회*/
		UserRequestDTO requestDetail = new MyReqService().selectRequestDetail(userRequestDTO);
		
		String path = "";
		
		/* 성공 실패시 페이지 이동*/
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
