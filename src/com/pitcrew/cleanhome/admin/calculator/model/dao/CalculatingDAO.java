package com.pitcrew.cleanhome.admin.calculator.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.calculator.model.dto.CalListDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.CalSettingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.CalculatingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.DeductRateDTO;
import com.pitcrew.cleanhome.common.paging.SelectAdminCriteriaForCal;

public class CalculatingDAO {

	/* 정산 여부 체크 */
	public List<CalSettingDTO> selectCalCheck(SqlSession session) {
		
		return session.selectList("CalculatingDAO.selectCalCheck");
	}
	
	/* 정산 기초자료 조회 */
	public List<CalculatingDTO> selectCalSetting(SqlSession session, SelectAdminCriteriaForCal selectAdminCriteriaForCal) {
		
		return session.selectList("CalculatingDAO.selectCalSetting", selectAdminCriteriaForCal);
	}

	public DeductRateDTO selectdeductRate(SqlSession session) {
		
		return session.selectOne("CalculatingDAO.selectdeductRate");
	}

	/* 정산 대기 등록*/
	public int insertCal(SqlSession session, Map<String, List<CalListDTO>> buckitList) {
	
		
		return session.insert("CalculatingDAO.insertCal", buckitList);
	}


	public int insertStatus(SqlSession session, int calNo) {
		
		return session.insert("CalculatingDAO.insertStatus", calNo);
	}


	public int selectAllCount(SqlSession session, Map<String, String> searchWord) {
		
		return session.selectOne("CalculatingDAO.selectAllCount", searchWord);
	}


	public List<CalculatingDTO> selectCalList(SqlSession session, SelectAdminCriteriaForCal selectAdminCriteriaForCal) {
		
		return session.selectList("CalculatingDAO.selectCalList", selectAdminCriteriaForCal);
	}

	/* 회원번호 별 정산번호 알아오기 */
	public List<CalculatingDTO> selectCalNum(SqlSession session) {
		
		return session.selectList("CalculatingDAO.selectCalNum");
	}



	

}
