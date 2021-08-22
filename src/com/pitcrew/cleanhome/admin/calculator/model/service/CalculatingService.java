package com.pitcrew.cleanhome.admin.calculator.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.calculator.model.dao.CalculatingDAO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.CalListDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.CalSettingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.CalculatingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.DeductRateDTO;
import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.common.paging.SelectAdminCriteria;
import com.pitcrew.cleanhome.common.paging.SelectAdminCriteriaForCal;

public class CalculatingService {

	private final CalculatingDAO calDAO;

	public CalculatingService() {
		calDAO = new CalculatingDAO();

	}

	/* 정산 기초자료 계산하기 */
	public List<CalculatingDTO> selectCalSetting(Map<String, String> searchMap) {
		SqlSession session = getSqlSession();

		/* 정산 기초 자료 */
		List<CalculatingDTO> calSettingList = calDAO.selectCalSetting(session, searchMap);
		/* 공제율 */
		DeductRateDTO incometaxRate = calDAO.selectdeductRate(session);
		
		List<CalculatingDTO> perReqCalcList = new ArrayList<>();
		
		System.out.println("서비스 내 정산 기초자료 체크 : " + calSettingList);
		
		for(CalculatingDTO calcul : calSettingList) {
			CalculatingDTO calc = new CalculatingDTO();
			
			int cleanerincome = calcul.getRequest().getCleanerIncome(); // 해결사 지급 총액

			float incometaxrate = incometaxRate.getRate(); // 해결사 소득세율 
			int incometax = 0; // 해결사 소득세액 
			int residenttax = 0; // 해결사 주민세액 
			int transferPrice = 0; // 해결사 실수령액

			incometax = (int)(Math.floor((cleanerincome * incometaxrate) / 10) * 10 ) ;
			residenttax = (int)(Math.floor((cleanerincome * incometaxrate * 0.1) / 10) * 10); 

			System.out.println("소득세액 : " + incometax); System.out.println("주민세액 : " + residenttax);

			transferPrice = cleanerincome - incometax - residenttax;
			System.out.println("해결사 실 수령액 : " + transferPrice);

			calc.setCleaner(calcul.getCleaner());
			calc.setIncometax(incometax); 
			calc.setResidenttax(residenttax);
			calc.setCleanerTransferPrice(transferPrice);
			calc.setRequest(calcul.getRequest());

			perReqCalcList.add(calc); 

		}
		
		System.out.println("서비스 리턴값 체크 " + perReqCalcList);
		session.close();

		return perReqCalcList;
	}




	/* 개인별 req번호와 함께 테이블에 입력 */
	public int insertReqNum(List<CalListDTO> cal) {

		SqlSession session = getSqlSession();

		/* 개인별 정산 총액을 계산해서 담아준다 */

		Map<String, List<CalListDTO>> buckitList = new HashMap<>();
		List<CalListDTO> buckit = null;
		
		for(CalListDTO calc : cal) {
			String cleanerNo = String.valueOf(calc.getMemNo()); //키
						
			/* value 값 */
			if(buckitList.keySet().contains(cleanerNo)) {
				
				buckit = buckitList.get(cleanerNo);
				
				buckit.add(calc);
				
			} else {
				buckit = new ArrayList<>();
				buckit.add(calc);
				buckitList.put(cleanerNo, buckit);
			}
			
		}
		
		// 건별 insert
		
		CalListDTO sumDTO = new CalListDTO();
		
		Iterator<String> keys = buckitList.keySet().iterator();
		while ( keys.hasNext() ) {
		    String key = keys.next();
		    buckit = buckitList.get(key);
		    int calcPrice = 0;
		    int incometax = 0;
		    int residenttax = 0;
		    int transferPrice = 0;
		    int cnt = 0;
			System.out.println("key : " + key);
			if(buckit.size() > 1){
				for(int j = 0; j < buckit.size(); j++) {
					calcPrice += buckit.get(j).getCalcPrice();
					incometax += buckit.get(j).getIncomeTax();
					residenttax += buckit.get(j).getResidentTax();
					transferPrice += buckit.get(j).getTransferPrice();					
					cnt++;
					System.out.println("buckit size : " + buckit.size());
					System.out.println("cnt : " + cnt);
					System.out.println("for문 내 연산 체크, calcPrice : " + j +"번째 " + calcPrice);
					if(cnt == buckit.size()) {
						sumDTO.setCalcPrice(calcPrice);
						sumDTO.setIncomeTax(incometax);
						sumDTO.setResidentTax(residenttax);
						sumDTO.setTransferPrice(transferPrice);
						buckit.removeAll(buckit);
						buckit.add(sumDTO);
						System.out.println("buckit : " + buckit);
						buckitList.put(key, buckit);
						System.out.println("buckitList : " + buckitList);
					}
			}
			
			}
			System.out.println("while buckitList : " + buckitList);
			
			
		}  
			
	
			
			
		System.out.println("for 연산 후 버킷리스트 : " + buckitList.size());	
		System.out.println("버킷리스트를 꺼낸다 : " + buckitList);
		


		/* DB 등록 */
	//	int result = calDAO.insertReqNum(session, buckitList);
	//	List<CalculatingDTO> memNoAndCalNo = calDAO.selectCalNum(session);

	//	Map<String, Object> reqMap = new HashMap<>();

	/*	for(int i = 0; i < cal.size(); i++) {

			for(int j = 0; j < memNoAndCalNo.size(); j++) {
				int calNum = cal.get(i).getMemNo();
				if(calNum == memNoAndCalNo.get(j).getCleaner().getMemNo()) {
					reqMap.put("calNo", memNoAndCalNo.get(j).getCalNo());
					reqMap.put("reqNo", cal.get(i));



				}
			}


		}


		if(result > 0) {
			session.commit();
			System.out.println("at 서비스 : 해소용 테이블 등록 성공");
		} else {
			session.rollback();
			System.out.println("at 서비스 : 해소용 테이블 등록 실패");
		}*/
		int result = 0;
		return result;
	}

	/* 정산 대기 상태로 변경 */
	public int insertStatus(int calNo) {

		SqlSession session = getSqlSession();

		int result = calDAO.insertStatus(session, calNo);

		if(result > 0) {
			session.commit();
			System.out.println("at 서비스 : 정산상태 등록 성공");
		} else {
			session.rollback();
			System.out.println("at 서비스 : 정산상태 등록 실패");
		}

		return result;
	}

	/* 페이징 처리용 리스트 불러오기*/
	public int selectTotalCount(Map<String, String> searchWord) {

		SqlSession session = getSqlSession();

		int totalCount = calDAO.selectAllCount(session, searchWord);

		session.close();

		return totalCount;
	}


	public List<CalculatingDTO> selectCalList(SelectAdminCriteriaForCal selectAdminCriteriaForCal) {

		SqlSession session = getSqlSession();

		List<CalculatingDTO> calList = calDAO.selectCalList(session, selectAdminCriteriaForCal);

		System.out.println("서비스 리턴값 체크 " + calList);

		session.close();

		return calList;
	}















}
