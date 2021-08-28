package com.pitcrew.cleanhome.user.request.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.user.request.model.dto.UserRequestDTO;
import com.pitcrew.cleanhome.user.request.model.service.MyReqService;

@WebServlet("/user/select/myRequest")
public class SelectMyRequestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 세션에 저장된 로그인 정보를 가지고 온다.*/
		HttpSession session = request.getSession();
		
		/* 세션에 저장된 loginMember MemberDTO 타입으로 캐스팅 */
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		/* 로드인 된 회원 번호를 변수에 초기화 해준다.*/
		int memNoUser = loginMember.getMemNo();
		
		/* 회원 번호를 인자값으로 넘긴 후 유저의 의뢰 정보를 조회한다. */
		List<UserRequestDTO> selectMyAllReq = new MyReqService().selectMyAllReq(memNoUser);
		 		
		/* 페이지 경로 설정 */
		String path = "";
		
		
		if(selectMyAllReq != null) {
			
			/* 조회 결과 값이 null값이 아닐 때 이동하는 페이지 */
			path = "/WEB-INF/views/user/request/myRequest.jsp";
			request.setAttribute("selectMyAllReq", selectMyAllReq);
			
		} else {
			
			/* 조회 결과 값이 null값일 때 이동하는 페이지 */
			path ="/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "의뢰 조회 실패하셨습니다 !!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
