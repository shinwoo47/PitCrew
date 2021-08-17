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

public class CalculatingService {

	private final CalculatingDAO calDAO;
	
	public CalculatingService() {
		calDAO = new CalculatingDAO();
		
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
	
	public int selectTotalCount(Map<String, String> searchMap) {
		
		return 0;
	}


	public List<CalculatingDTO> selectCalList(SelectAdminCriteria selectAdminCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	


	

}
