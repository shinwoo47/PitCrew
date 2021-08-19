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
		
		Calendar time = Calendar.getInstance();
		String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		String month = String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1);
		String edate = format.format(time.getTime());
		String sdate = year + "-" + month + "-01";
		
		Date date = new Date();
		if(request.getParameter("date") != null) {
			sdate = request.getParameter("date");
		}
		
		System.out.println("sdate : " + sdate);
		
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
		int memNo = member.getMemNo();
		
		Map<String, Object> calculateMap = new HashMap<>();
		calculateMap.put("date", sdate);
		calculateMap.put("memNo", memNo);
		CalculateDTO calculate = calculateService.selectCalculate(calculateMap);
		ProductSumDTO productCalculate = calculateService.CalculateProduct(calculateMap);
		
		System.out.println(calculate);
		
		System.out.println("sum : " + productCalculate);

		String path = "/WEB-INF/views/cleaner/calculatelist.jsp";
		request.setAttribute("calculate", calculate);
		request.setAttribute("productSum", productCalculate);
	
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
