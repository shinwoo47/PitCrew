package com.pitcrew.cleanhome.admin.calculator.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.calculator.model.dao.CalculatingDAO;
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
		/* 기정산된 의뢰번호 */
		List<CalSettingDTO> reqCheckList = calDAO.selectCalCheck(session);
		
		List<CalculatingDTO> perReqCalcList = new ArrayList<>();
		
		for(int i = 0; i < calSettingList.size(); i++) {

			int calReqNo = calSettingList.get(i).getRequest().getReqNo();
			
			if(reqCheckList.isEmpty() || calReqNo != (reqCheckList.get(i).getReqNo())) {
				
				CalculatingDTO calc = new CalculatingDTO();
				int cleanerincome = calSettingList.get(i).getRequest().getCleanerIncome();	// 해결사 지급 총액
					 
				float incometaxrate = incometaxRate.getRate(); 		// 해결사 소득세율
				int incometax = 0;				// 해결사 소득세액
				int residenttax = 0;			// 해결사 주민세액
				int transferPrice = 0;		 // 해결사 실수령액

				incometax = (int)(Math.floor((cleanerincome * incometaxrate) / 10) * 10 ) ;
				residenttax = (int)(Math.floor((cleanerincome * incometaxrate * 0.1) / 10) * 10);
				System.out.println("소득세액 : " + incometax);
				System.out.println("주민세액 : " + residenttax);
				
				transferPrice = cleanerincome - incometax - residenttax;
				System.out.println("해결사 실 수령액 : " + transferPrice);
				
				calc.setCleaner(calSettingList.get(i).getCleaner());
				calc.setIncometax(incometax);
				calc.setResidenttax(residenttax);
				calc.setCleanerTransferPrice(transferPrice);
				calc.setRequest(calSettingList.get(i).getRequest());
				
				perReqCalcList.add(calc);
			}
		}
		
		System.out.println("서비스 리턴값 체크 " + perReqCalcList);
		session.close();

		return perReqCalcList;
	}

	
	/* 등록할 정산번호 확인 */
	public int selectCalNum() {
		SqlSession session = getSqlSession();

		int calNum = calDAO.selectCalNum(session);

		if(calNum > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		System.out.println("서비스 리턴값 체크 " + calNum);

		return calNum;
	}

	/* 정산 대기 상태로 등록 */
	public int insertCal(Map<String, Integer> calculatingMap) {

		SqlSession session = getSqlSession();

		int result = calDAO.insertCal(session, calculatingMap);

		if(result > 0) {
			session.commit();
			System.out.println("at 서비스 : 정산 대기 등록 성공");
		} else {
			session.rollback();
			System.out.println("at 서비스 : 정산 대기 등록 실패");
		}

		return result;
	}

	/* req번호와 함께 테이블에 입력 */
	public int insertReqNum(Map<String, Integer> calculatingMap) {
		
		SqlSession session = getSqlSession();

		int result = calDAO.insertReqNum(session, calculatingMap);

		if(result > 0) {
			session.commit();
			System.out.println("at 서비스 : 해소용 테이블 등록 성공");
		} else {
			session.rollback();
			System.out.println("at 서비스 : 해소용 테이블 등록 실패");
		}

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
