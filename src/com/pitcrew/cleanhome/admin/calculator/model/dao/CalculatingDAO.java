package com.pitcrew.cleanhome.admin.calculator.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.calculator.model.dto.CalSettingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.CalculatingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.DeductRateDTO;
import com.pitcrew.cleanhome.common.paging.SelectAdminCriteriaForCal;

public class CalculatingDAO {

	/* 정산 여부 체크 */
	public List<CalSettingDTO> selectCalCheck(SqlSession session) {
		
		return session.selectList("CalculatingDAO.selectCalCheck");
	}
	
	
	public List<CalSettingDTO> selectCalSetting(SqlSession session, Map<String, String> searchMap) {
		
		return session.selectList("CalculatingDAO.selectCalSetting", searchMap);
	}

	public List<DeductRateDTO> selectdeductRate(SqlSession session) {
		
		return session.selectList("CalculatingDAO.selectdeductRate");
	}

	/* 등록할 정산 번호 curval 체크 */
	public int selectCalNum(SqlSession session) {
		
		return session.selectOne("CalculatingDAO.selectCalNum");
	}

	/* 정산 대기 등록 */
	public int insertCal(SqlSession session, Map<String, Integer> calculatingMap) {
		
		return session.insert("CalculatingDAO.insertCal", calculatingMap);
	}


	public int insertReqNum(SqlSession session, Map<String, Integer> calculatingMap) {
	
		
		return session.insert("CalculatingDAO.insertReqNum", calculatingMap);
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

	

}
