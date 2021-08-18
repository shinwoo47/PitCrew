package com.pitcrew.cleanhome.admin.calculator.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

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

	/* 정산한 의뢰 번호 불러오기 */
	public List<CalSettingDTO> selectCalCheck() {

		SqlSession session = getSqlSession();

		List<CalSettingDTO> calCheckList = calDAO.selectCalCheck(session);

		System.out.println("정산 의뢰번호 서비스 리턴값 체크 " + calCheckList);
		session.close();

		return calCheckList;
	}


	/* 정산 기초자료 불러오기 */
	public List<CalSettingDTO> selectCalSetting(Map<String, String> searchMap) {
		SqlSession session = getSqlSession();

		List<CalSettingDTO> calSettingList = calDAO.selectCalSetting(session, searchMap);

		System.out.println("서비스 리턴값 체크 " + calSettingList);
		session.close();

		return calSettingList;
	}

	/* 공제율 불러오기 */
	public List<DeductRateDTO> selectDeductRate() {
		SqlSession session = getSqlSession();

		List<DeductRateDTO> deductRateList = calDAO.selectdeductRate(session);

		System.out.println("서비스 리턴값 체크 " + deductRateList);
		session.close();

		return deductRateList;
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
