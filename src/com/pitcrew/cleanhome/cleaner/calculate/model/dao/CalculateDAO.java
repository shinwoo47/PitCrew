package com.pitcrew.cleanhome.cleaner.calculate.model.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.cleaner.calculate.model.dto.CalculateByRequestDTO;
import com.pitcrew.cleanhome.cleaner.calculate.model.dto.CalculateDTO;
import com.pitcrew.cleanhome.cleaner.calculate.model.dto.ProductSumDTO;

public class CalculateDAO {

	public CalculateDTO selectCalculate(SqlSession session, Map<String, Object> calculateMap) {
		
		return session.selectOne("CalculateDAO.selectCalculate", calculateMap);
	}

	public ProductSumDTO calculateProduct(SqlSession session, Map<String, Object> calculateMap) {
		
		return session.selectOne("CalculateDAO.calculateProduct", calculateMap);
	}

	public List<CalculateByRequestDTO> selectCalculateDetail(SqlSession session, int calNo) {
		
		return session.selectList("CalculateDAO.selectCalculateDetail", calNo);
	}

}
