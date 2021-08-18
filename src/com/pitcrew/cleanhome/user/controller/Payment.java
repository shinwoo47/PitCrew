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

		HttpSession session = request.getSession();
		CleanDTO clean = new CleanDTO();
		
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember"); 
		System.out.println("현재회원번호 : " + member);
		clean = new CleanService().selectMember(member);
		
		List<Integer> productNo = new ArrayList<Integer>(5);
		
		int optPrice = 5000;
		double optTime = 0.5;
		/*db등록*/
		//총가격
		clean.setProPrice(Integer.parseInt(request.getParameter("CleanPrice")));
		clean.setTime(Double.parseDouble(request.getParameter("CleanTime")));
		//상품번호
		clean.setProductNo(Integer.parseInt(request.getParameter("cleanNo")));
		productNo.add(clean.getProductNo());
		if(request.getParameter("optionNo1") != null)	 {
			clean.setOptionNo1(Integer.parseInt(request.getParameter("optionNo1")));
			clean.setProPrice(clean.getProPrice() + optPrice);
			clean.setTime(clean.getTime() + optTime);
			productNo.add(clean.getOptionNo1());
			System.out.println(productNo.get(1));
		}
		if(request.getParameter("optionNo2") != null)	 {
			clean.setOptionNo2(Integer.parseInt(request.getParameter("optionNo2")));
			System.out.println(clean.getOptionNo2());
			clean.setProPrice(clean.getProPrice() + optPrice);
			clean.setTime(clean.getTime() + optTime);
			productNo.add(clean.getOptionNo2());
			System.out.println(productNo.get(2));
		}
		//내용
		clean.setReqReq(request.getParameter("content"));
		
		String ta = request.getParameter("start");
		String tb = request.getParameter("startTime");
		clean.setRewDate(ta +" " + tb);
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {
			clean.setReqDate(format2.parse(clean.getRewDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

//		clean.setPrice(Integer.parseInt(request.getParameter("startTime"))); 
		/*구매자 정보*/
		//이름+
		//이메일+
		//휴대폰 번호+
		
		//시작일
		//주소+
		//청소시간
//		clean.setTime(Integer.parseInt(request.getParameter("CleanTime")));
		
		
		
		System.out.println(clean);
		int num = 1;
		String path = "";
		if (num > 0) {
			path = "/WEB-INF/views/user/request/payment.jsp";
			request.setAttribute("clean", clean);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "서비스이동실패");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

}
