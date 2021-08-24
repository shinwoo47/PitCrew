package com.pitcrew.cleanhome.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.user.model.dto.CleanDTO;
import com.pitcrew.cleanhome.user.model.service.CleanService;

@WebServlet("/user/clean/list")
public class SelectCleanIntroductionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * number 를 받아와 DB에서 청소 번호에 해당하는 청소 내용 소개
		 */
		
		/* 청소 번호를  num 변수에 초기화 */
		int num = Integer.parseInt(request.getParameter("number"));  
		
		CleanDTO clean = new CleanDTO();
		
		/* 청소 번호에 해당하는 메소드 실행 */
		if(num == 1) {
			clean = new CleanService().selectClean(num);		/* 서비스로 값 전달 */
			clean.setImgNo("roomClean.png");					/* 사진 이름을 객체에 값을 초기화 */
		} else if(num == 2) {
			clean = new CleanService().selectClean(num);
			clean.setImgNo("bathroomClean.png");
		} else if(num == 3) {
			clean = new CleanService().selectClean(num);
			clean.setImgNo("allClean.png");
		} else if(num == 4) {
			clean = new CleanService().selectClean(num);
			clean.setImgNo("washDish.png");
		} else if(num == 5) {
			clean = new CleanService().selectClean(num);
			clean.setImgNo("windowClean.png");
		}
		String path = "";
			
		if(num > 0) {
			path = "/WEB-INF/views/user/information.jsp";
			request.setAttribute("clean", clean);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "서비스이동실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}



}
