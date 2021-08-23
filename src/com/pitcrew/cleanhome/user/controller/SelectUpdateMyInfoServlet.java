package com.pitcrew.cleanhome.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.user.model.service.MyInfoService;

@WebServlet("/user/member/selectUpdate/myInfo")
public class SelectUpdateMyInfoServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 세션에 저장된 로그인 정보를 가지고 온다.*/
		HttpSession session = request.getSession();
		
		/* 세션에 저장된 loginMember MemberDTO 타입으로 캐스팅*/
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		int memNo = loginMember.getMemNo();
		
		/* 회원정보를 수정하기 위해 필요한 유저 정보를 리스트로 담고 호출*/
		List<MemberDTO> selectUpdateMyInfo = new MyInfoService().selectUpdateMyInfo(memNo);
		
		/* 성공 실패시 페이지 이동*/
		String path = "";
		if(selectUpdateMyInfo != null) {
			path = "/WEB-INF/views/user/member/selectUpdateMyInfo.jsp";
			request.setAttribute("selectUpdateMyInfo", selectUpdateMyInfo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원정보 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		/* 수정할 정보를 입력 후 파라미터로 전달된 값을 변수에 저장한다.*/
		int memNo = loginMember.getMemNo();
		String pwd = request.getParameter("memberPwd");
		String address = request.getParameter("zipCode") + "$" + request.getParameter("address1") + "$" + request.getParameter("address2");
		String email = request.getParameter("updateEmail");
		
		/* 파라미터 값을 초기화 했던 변수를 dto에 담아줌*/
		MemberDTO updateMember = new MemberDTO();
		updateMember.setMemNo(memNo);
		updateMember.setPwd(pwd);
		updateMember.setAddress(address);
		updateMember.setEmail(email);
		
		System.out.println("updateMember : " + updateMember);
		
		/* 업데이트한 결과가 1인지 0인지 판단하기 위함 1이면 true 아니면 false*/
		int result = new MyInfoService().updateMyInfo(updateMember);
		
		String page = "";
		
		if(result > 0) {
			page = "/WEB-INF/views/common/success.jsp";
			
			request.setAttribute("successCode", "updateUserInfo");
		} else {
			page = "/WEB-INF/views/common/failed.jsp";
			
			request.setAttribute("message", "회원정보 실패!");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}
}
