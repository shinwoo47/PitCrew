package com.pitcrew.cleanhome.admin.calculator.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.calculator.model.dto.CalSettingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.CalculatingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.DeductRateDTO;

public class CalculatingDAO {

	public List<CalSettingDTO> selectCalSetting(SqlSession session, Map<String, String> searchMap) {
		
		return session.selectList("CalculatingDAO.selectCalSetting", searchMap);
	}

	public List<DeductRateDTO> selectdeductRate(SqlSession session) {
		
		return session.selectList("CalculatingDAO.selectdeductRate");
	}

}
