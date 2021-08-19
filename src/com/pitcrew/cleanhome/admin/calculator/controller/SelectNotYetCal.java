package com.pitcrew.cleanhome.admin.calculator.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.calculator.model.dto.CalSettingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.CalculatingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.DeductRateDTO;
import com.pitcrew.cleanhome.admin.calculator.model.service.CalculatingService;

@WebServlet("/admin/yetcal/list")
public class SelectNotYetCal extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("controller 진입 성공");

		/* 입력받은 정산 기간을 hashMap에 넣기*/
		String searchStartDate = null;
		if(request.getParameter("searchStartDate") != null && !"".equals(request.getParameter("searchStartDate"))) {
			searchStartDate = (request.getParameter("searchStartDate"));
		}

		String searchEndDate = null;
		if(request.getParameter("searchEndDate") != null && !"".equals(request.getParameter("searchEndDate"))) {
			searchEndDate = (request.getParameter("searchEndDate"));
		}

		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchStartDate", searchStartDate); // 날짜 조회
		searchMap.put("searchEndDate", searchEndDate); // 날짜 조회


		/* 해당 기간에 맞는 미정산 리스트를 불러온다*/
		CalculatingService calculatingService = new CalculatingService();
		List<CalculatingDTO> perReqCalcList = calculatingService.selectCalSetting(searchMap);
		System.out.println("controller calSettingList : " + perReqCalcList);

		String path = "";
		if(perReqCalcList != null) {
			path = "/WEB-INF/views/admin/calculator/notYetCalList.jsp";
			request.setAttribute("perReqCalcList", perReqCalcList);
		} else {
			path = "/WEB-INF/common/failed.jsp";
			request.setAttribute("message", "조회에 실패했습니다.");
		}

		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("post로 넘어옴");
		// 받은 데이터를 차례로 넣어준다? 아무튼 처리한다
		
		
		/* 조회해온다 
		List<CalculatingDTO> calList = calculatingService.selectCalList(selectAdminCriteriaForCal);
		System.out.println("calList : " + calList);

		Map<String, List<CalculatingDTO>> buckitList = new HashMap<>();
		List<CalculatingDTO> buckit;
		
		int cleanerincome = 0;
		int incometax = 0;
		int residenttax = 0;
		int cleanertransferPrice = 0;
		
		for(CalculatingDTO calc : calList) {
			String cleanerNo = String.valueOf(calc.getCleanerNo());
			if(buckitList.keySet().contains(cleanerNo)) {
				buckit = buckitList.get(cleanerNo);
				buckit.add(calc);
				for(int i = 0; i < buckit.size(); i++) {
					cleanerincome += buckit.get(i).getCleanerIncome();
					incometax += buckit.get(i).getIncometax();
					residenttax += buckit.get(i).getResidenttax();
					cleanertransferPrice += buckit.get(i).getCleanerTransferPrice();
				}
			} else {
				buckit = new ArrayList<>();
				buckit.add(calc);
				buckitList.put(cleanerNo, buckit);
			}
			
		}*/
		
		/* 정산번호 및 회원번호 체크 
		int calNo = calculatingService.selectCalNum();
		System.out.println("정산번호 체크 : " + calNo);
		
		int cleanerNo = calSettingList.get(i).getCleaner().getMemNo(); //회원번호 체크
		
		System.out.println(cleanerNo);*/
		
		
		
		/* 폼 전송 되면 db에 인서트 해준다. 
		Map<String, Integer> calculatingMap = new HashMap<>();
		calculatingMap.put("calNo", calNo);
		calculatingMap.put("cleanerNo", cleanerNo); // 회원번호 입력
		calculatingMap.put("cleanerIncome", cleanerincome); // 정산금액 입력
		calculatingMap.put("cleanerTransferPrice", transferPrice); // 실수령액
		calculatingMap.put("incometax", incometax); //소득세
		calculatingMap.put("residenttax", residenttax); //주민세
		calculatingMap.put("calReqNo", calReqNo);
		
		System.out.println(calculatingMap);*/
		
		/* DB에 입력 
		int inputtable = calculatingService.insertCal(calculatingMap);
		int reqPeriodTbl = calculatingService.insertReqNum(calculatingMap);
		int statusSet = calculatingService.insertStatus(calNo);*/
			 
	}

}
