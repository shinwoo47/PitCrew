package com.pitcrew.cleanhome.admin.calculator.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.calculator.model.dao.CalculatingDAO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.CalculatingDTO;
import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.common.paging.SelectAdminCriteria;

public class CalculatingService {

	private final CalculatingDAO calDAO;
	
	public CalculatingService() {
		calDAO = new CalculatingDAO();
		
	}
	
	public List<CalculatingDTO> selectCalSetting() {
		SqlSession session = getSqlSession();

		List<CalculatingDTO> calSettingList = calDAO.selectCalSetting(session);

		System.out.println("서비스 리턴값 체크 " + calSettingList);
		session.close();

		return calSettingList;
	}
	
	
	public int selectTotalCount(Map<String, String> searchMap) {
		
		return 0;
	}


	public List<CalculatingDTO> selectCalList(SelectAdminCriteria selectAdminCriteria) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
