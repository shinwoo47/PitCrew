package com.pitcrew.cleanhome.admin.calculator.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
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
import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.common.paging.AdminPagenationForCal;
import com.pitcrew.cleanhome.common.paging.SelectAdminCriteriaForCal;

@WebServlet("/admin/calculating/list")
public class SelectCalculating extends HttpServlet {

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


		/* 해당 기간에 맞는, 계산할 금액들을 불러온다*/
		CalculatingService calculatingService = new CalculatingService();
		List<CalSettingDTO> calSettingList = calculatingService.selectCalSetting(searchMap);
		System.out.println("controller calSettingList : " + calSettingList);

		List<DeductRateDTO> deductRateList = calculatingService.selectDeductRate();
		System.out.println("controller rate List : " + deductRateList);

		/* 기정산된 의뢰번호를 조회해 온다. */
		List<CalSettingDTO> reqCheckList = calculatingService.selectCalCheck();
		System.out.println("controller cal 수행 여부 : " + reqCheckList);


		for(int i = 0; i < calSettingList.size(); i++) {

			int calReqNo = calSettingList.get(i).getReqNo();
			
			if( reqCheckList.isEmpty() || calReqNo != (reqCheckList.get(i).getReqNo())) {

				int calPrice = calSettingList.get(i).getPay().getPrice();	//소비자 결제금액
				float vat = 0f;				// 부가세
				int supplyPrice = 0;		 // 공급가액
				float cardrate = 0f;			// 카드 수수료율
				float marginrate = 0f;		// 사업장 운영비 공제율
				int cleanerincome = 0;		 // 해결사 지급 총액
				float incometaxrate = 0f;		// 해결사 소득세율
				float residenttaxrate = 0f;		// 해결사 주민세율
				int incometax = 0;				// 해결사 소득세액
				int residenttax = 0;			// 해결사 주민세액
				int transferPrice = 0;		 // 해결사 실수령액
				int deductSum = 0;			 //공제 합계

				/* 리스트로 가져온 공제율 꺼내기*/
				for(int j = 0; j < deductRateList.size(); j++) {
					if((deductRateList.get(j).getDeductName()).equals("VAT")) {
						vat = deductRateList.get(j).getRate();
					} else if((deductRateList.get(j).getDeductName()).equals("cardrate")) {
						cardrate = deductRateList.get(j).getRate();
					} else if((deductRateList.get(j).getDeductName()).equals("margin")) {
						marginrate = deductRateList.get(j).getRate();
					} else if((deductRateList.get(j).getDeductName()).equals("incometax")) {
						incometaxrate = deductRateList.get(j).getRate();
					} 
				}

				supplyPrice = (int)(Math.floor((calPrice/(1+vat)) / 10)) * 10; // 공급가액

				System.out.println("공급가액 : " + supplyPrice);

				/* 청소 해결사 지급 총액 구하기 */
				deductSum = (int) ((calPrice - supplyPrice) + (calPrice * cardrate) + (calPrice * marginrate)); //부가세 + 카드수수료율 + 운영비  

				cleanerincome = calPrice - deductSum;   //해결사 지급 총액

				System.out.println("공제 총액 : " + deductSum);
				System.out.println("지급 총액 : " + cleanerincome);

				incometax = (int)(Math.floor((cleanerincome * incometaxrate) / 10) * 10 ) ;
				residenttax = (int)(Math.floor((cleanerincome * incometaxrate * 0.1) / 10) * 10);
				System.out.println("소득세액 : " + incometax);
				System.out.println("주민세액 : " + residenttax);

				transferPrice = cleanerincome - incometax - residenttax;
				System.out.println("해결사 실 수령액 : " + transferPrice);
				
				
				/* 정산번호 및 회원번호 체크 */
				int calNo = calculatingService.selectCalNum();
				System.out.println("정산번호 체크 : " + calNo);
				
				int cleanerNo = calSettingList.get(i).getCleaner().getMemNo(); //회원번호 체크
				
				System.out.println(cleanerNo);
				
				/* 계산 결과를 db에 인서트 해준다.(정산 대기 상태) */
				Map<String, Integer> calculatingMap = new HashMap<>();
				calculatingMap.put("calNo", calNo);
				calculatingMap.put("cleanerNo", cleanerNo); // 회원번호 입력
				calculatingMap.put("cleanerIncome", cleanerincome); // 정산금액 입력
				calculatingMap.put("cleanerTransferPrice", transferPrice); // 실수령액
				calculatingMap.put("incometax", incometax); //소득세
				calculatingMap.put("residenttax", residenttax); //주민세
				calculatingMap.put("calReqNo", calReqNo);
								
				System.out.println(calculatingMap);
				
				/* DB에 입력 */
				int inputtable = calculatingService.insertCal(calculatingMap);
				int reqPeriodTbl = calculatingService.insertReqNum(calculatingMap);
				int statusSet = calculatingService.insertStatus(calNo);
				
			}
		}


		/* 페이징 처리 */
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
			searchCondition = (request.getParameter("searchCondition"));

		}
		String searchValue = null;
		if(request.getParameter("searchValue") != null && !"".equals(request.getParameter("searchValue"))) {
			searchValue = (request.getParameter("searchValue"));

		}

		String searchStatusValue = null;

		/* 정산상태 db랑 텍스트 일치 시키기 */
		if(request.getParameter("statusValue") != null && !"".equals(request.getParameter("statusValue"))) {
			searchStatusValue = (request.getParameter("statusValue"));
		}


		Map<String, String> searchWord = new HashMap<>();
		searchWord.put("searchCondition", searchCondition);  //검색어 입력
		searchWord.put("searchValue", searchValue); 		// 입력 값
		searchWord.put("searchStatus", searchStatusValue); // 정산 상태 선택 

		/* 전체 게시물 수가 필요하다.
		 * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
		 * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
		 * */

		int totalCount = calculatingService.selectTotalCount(searchWord);

		System.out.println("totalCount : " + totalCount);

		/* 한 페이지에 보여 줄 게시물 수 */	
		int limit = 15;	
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5; 

		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다.*/
		SelectAdminCriteriaForCal selectAdminCriteriaForCal = null;

		if(searchCondition != null && !"".equals(searchCondition)) {
			selectAdminCriteriaForCal = AdminPagenationForCal.getSelectAdminCriteriaForCal(pageNo, totalCount, limit, buttonAmount, 
										searchCondition, searchValue, searchStartDate, searchEndDate, searchStatusValue);
		} else {
			selectAdminCriteriaForCal = AdminPagenationForCal.getSelectAdminCriteriaForCal(pageNo, totalCount, limit, buttonAmount);
		}

		System.out.println(selectAdminCriteriaForCal); 

		/* 조회해온다 */
		List<CalculatingDTO> calList = calculatingService.selectCalList(selectAdminCriteriaForCal);

		System.out.println("calList : " + calList);




		String path = "";

		/*		
		if(calList != null) {
			path = "/WEB-INF/views/admin/calculator/calList.jsp";
			request.setAttribute("calList", calList);
			request.setAttribute("selectAdminCriteria", selectAdminCriteria);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "목록 조회 실패!");
		}



		request.getRequestDispatcher(path).forward(request, response);*/

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
