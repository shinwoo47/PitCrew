package com.pitcrew.cleanhome.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.user.model.dto.CleanDTO;

@WebServlet("/user/clean/payment")
public class Payment extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		/* int memno = (int) session.getAttribute("loginMember"); */

		CleanDTO clean = new CleanDTO();
		List productNo = new ArrayList();
		
		/*db등록*/
		//상품번호
		clean.setProductNo(Integer.parseInt(request.getParameter("cleanNo")));
		clean.setOptionNo1(Integer.parseInt(request.getParameter("optionNo1")));
		clean.setOptionNo2(Integer.parseInt(request.getParameter("optionNo2")));
		productNo.add(1, clean.getProductNo());
		productNo.add(2, clean.getOptionNo1());
		productNo.add(3, clean.getOptionNo2());
		//내용
		clean.setDemand(request.getParameter("content"));
		
//		clean.setPrice(Integer.parseInt(request.getParameter("startTime"))); 
		/*구매자 정보*/
		//이름+
		//이메일+
		//휴대폰 번호+
		
		//시작일
		//장소+
		//총가격
		clean.setProPrice(Integer.parseInt(request.getParameter("CleanPrice")));
		int optPrice = 5000;
		if(clean.getOptionNo1() == 4) {
			clean.setProPrice(clean.getProPrice() + optPrice);
		}
		if(clean.getOptionNo2() == 5) {
			clean.setProPrice(clean.getProPrice() + optPrice);
		}
		
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
