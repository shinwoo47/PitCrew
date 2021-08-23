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
import com.pitcrew.cleanhome.admin.calculator.model.dto.CalculatingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.DeductRateDTO;
import com.pitcrew.cleanhome.common.paging.SelectAdminCriteriaForCal;

public class CalculatingService {

	private final CalculatingDAO calDAO;

	public CalculatingService() {
		calDAO = new CalculatingDAO();

	}

	/* 정산 기초자료 계산하기 */
	public List<CalculatingDTO> selectCalSetting(SelectAdminCriteriaForCal selectAdminCriteriaForCal) {
		SqlSession session = getSqlSession();

		/* 정산 기초 자료 */
		List<CalculatingDTO> calSettingList = calDAO.selectCalSetting(session, selectAdminCriteriaForCal);
		/* 공제율 */
		DeductRateDTO incometaxRate = calDAO.selectdeductRate(session);
		
		List<CalculatingDTO> perReqCalcList = new ArrayList<>();
		
		
		for(CalculatingDTO calcul : calSettingList) {
			CalculatingDTO calc = new CalculatingDTO();
			
			int cleanerincome = calcul.getRequest().getCleanerIncome(); // 해결사 지급 총액

			float incometaxrate = incometaxRate.getRate(); // 해결사 소득세율 
			int incometax = 0; // 해결사 소득세액 
			int residenttax = 0; // 해결사 주민세액 
			int transferPrice = 0; // 해결사 실수령액

			incometax = (int)(Math.floor((cleanerincome * incometaxrate) / 10) * 10 ) ;
			residenttax = (int)(Math.floor((cleanerincome * incometaxrate * 0.1) / 10) * 10); 

		
			transferPrice = cleanerincome - incometax - residenttax;
			

			calc.setCleaner(calcul.getCleaner());
			calc.setIncometax(incometax); 
			calc.setResidenttax(residenttax);
			calc.setCleanerTransferPrice(transferPrice);
			calc.setRequest(calcul.getRequest());

			perReqCalcList.add(calc); 

		}
		
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
			
			if(buckit.size() > 1){
				for(int j = 0; j < buckit.size(); j++) {
					calcPrice += buckit.get(j).getCalcPrice();
					incometax += buckit.get(j).getIncomeTax();
					residenttax += buckit.get(j).getResidentTax();
					transferPrice += buckit.get(j).getTransferPrice();					
					cnt++;
					
					if(cnt == buckit.size()) {
						sumDTO.setMemNo(buckit.get(j).getMemNo());
						sumDTO.setCalcPrice(calcPrice);
						sumDTO.setIncomeTax(incometax);
						sumDTO.setResidentTax(residenttax);
						sumDTO.setTransferPrice(transferPrice);
						buckit.removeAll(buckit);
						buckit.add(sumDTO);
						
						buckitList.put(key, buckit);
						
					}
			}
			
			}
			
			
		}  
		
		session.close();
		
		/* DB 등록 */
		int result = 0;
		
		return result;
	}

	/* 정산 대기 상태로 변경 */
	public int insertStatus(int calNo) {

		SqlSession session = getSqlSession();

		int result = calDAO.insertStatus(session, calNo);

		if(result > 0) {
			session.commit();
		
		} else {
			session.rollback();
			
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

		

		session.close();

		return calList;
	}















}
