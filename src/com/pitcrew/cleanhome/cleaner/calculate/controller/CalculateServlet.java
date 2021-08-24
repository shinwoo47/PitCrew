package com.pitcrew.cleanhome.cleaner.calculate.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.cleaner.calculate.model.dto.CalculateDTO;
import com.pitcrew.cleanhome.cleaner.calculate.model.dto.ProductSumDTO;
import com.pitcrew.cleanhome.cleaner.calculate.model.service.CalculateService;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;


@WebServlet("/cleaner/calculate")
public class CalculateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		CalculateService calculateService = new CalculateService();
		
		/* 현재 날짜를 받아와 일자를 달의 첫날로 변경*/
		Calendar time = Calendar.getInstance();
		String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		String month = String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1);
		String edate = format.format(time.getTime());
		String sdate = year + "-" + month + "-01";
		
		/* 전달받은 년월 에서 일자를 1일로 표현*/
		Date date = new Date();
		if(request.getParameter("date") != null) {
			sdate = request.getParameter("date") + "-01";
		}		
		
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
		int memNo = member.getMemNo();
		
		/*정산을 조회할 일자와 회원 번호를 맵에 담기*/
		Map<String, Object> calculateMap = new HashMap<>();
		calculateMap.put("date", sdate);
		calculateMap.put("memNo", memNo);
		
		/* 맵에 담긴 값들을 이용하여 월별 정산과 월별 실적을 반환받기*/
		CalculateDTO calculate = calculateService.selectCalculate(calculateMap);
		ProductSumDTO productCalculate = calculateService.CalculateProduct(calculateMap);		

		String path = "/WEB-INF/views/cleaner/calculatelist.jsp";
		request.setAttribute("calculate", calculate);
		request.setAttribute("productSum", productCalculate);
	
		request.getRequestDispatcher(path).forward(request, response);
	}

}
