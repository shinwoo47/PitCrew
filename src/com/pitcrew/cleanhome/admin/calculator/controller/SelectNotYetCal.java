package com.pitcrew.cleanhome.admin.calculator.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.pitcrew.cleanhome.admin.calculator.model.dto.CalListDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.CalSettingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.CalculatingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.DeductRateDTO;
import com.pitcrew.cleanhome.admin.calculator.model.service.CalculatingService;
import com.pitcrew.cleanhome.admin.request.model.service.RequestService;
import com.pitcrew.cleanhome.common.paging.AdminPagenation;
import com.pitcrew.cleanhome.common.paging.AdminPagenationForCal;
import com.pitcrew.cleanhome.common.paging.SelectAdminCriteria;
import com.pitcrew.cleanhome.common.paging.SelectAdminCriteriaForCal;

@WebServlet("/admin/yetcal/list")
public class SelectNotYetCal extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		/* 0보다 작은 숫자값을 입력해도 1페이지를 보여준다 */
		if(pageNo <= 0) {
			pageNo = 1;
		}
			
		String searchCondition = null;
		if(request.getParameter("searchCondition") != null && !"".equals(request.getParameter("searchCondition"))) {
			searchCondition = request.getParameter("searchCondition");
		}
		
		String searchValue = null;
		if(request.getParameter("searchValue") != null && !"".equals(request.getParameter("searchValue"))) {
			searchValue	= request.getParameter("searchValue");
		}
		
		/* 입력받은 정산 기간을 hashMap에 넣기*/
		String searchStartDate = null;
		if(request.getParameter("searchStartDate") != null && !"".equals(request.getParameter("searchStartDate"))) {
			searchStartDate = (request.getParameter("searchStartDate"));
		}

		String searchEndDate = null;
		if(request.getParameter("searchEndDate") != null && !"".equals(request.getParameter("searchEndDate"))) {
			searchEndDate = (request.getParameter("searchEndDate"));
		}

		String searchStatusValue = null;
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition); //검색어 입력
		searchMap.put("searchValue", searchValue); // 입력 값
		searchMap.put("searchStartDate", searchStartDate); // 날짜 조회
		searchMap.put("searchEndDate", searchEndDate); // 날짜 조회

		/* 전체 게시물 수가 필요하다.
		 * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
		 * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
		 * */
		
		CalculatingService calculatingService = new CalculatingService();
		int totalCount = calculatingService.selectTotalCount(searchMap);


		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 15;		
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;

		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectAdminCriteriaForCal selectAdminCriteriaForCal = null;

		if(searchCondition != null && !"".equals(searchCondition)) {
			selectAdminCriteriaForCal = AdminPagenationForCal.getSelectAdminCriteriaForCal(pageNo, totalCount, limit, buttonAmount, 
										searchCondition, searchValue, searchStartDate, searchEndDate, searchStatusValue);
		} else {
			selectAdminCriteriaForCal = AdminPagenationForCal.getSelectAdminCriteriaForCal(pageNo, totalCount, limit, buttonAmount);
		}
		
		
		/* 해당 기간에 맞는 미정산 리스트를 불러온다*/
		
		List<CalculatingDTO> perReqCalcList = calculatingService.selectCalSetting(selectAdminCriteriaForCal);

		String path = "";
		if(perReqCalcList != null) {
			path = "/WEB-INF/views/admin/calculator/notYetCalList.jsp";
			request.setAttribute("perReqCalcList", perReqCalcList);
			request.setAttribute("selectAdminCriteriaForCal", selectAdminCriteriaForCal);
		} else {
			path = "/WEB-INF/common/failed.jsp";
			request.setAttribute("message", "조회에 실패했습니다.");
		}

		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String jsonStr = request.getParameter("calcList");
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd").create();	
		
		
		Type ListType = new TypeToken<List<CalListDTO>>(){}.getType();
		List<CalListDTO> cal = gson.fromJson(jsonStr, ListType);
		
		
		/* 서비스로 넘기고 서비스에서 연산 */
		CalculatingService calculatingService = new CalculatingService();
		
		
		/* DB에 입력 */
		int inputSetTbl = calculatingService.insertReqNum(cal);

			 
	}

}
