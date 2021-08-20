package com.pitcrew.cleanhome.cleaner.calculate.model.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.cleaner.calculate.model.dao.CalculateDAO;
import com.pitcrew.cleanhome.cleaner.calculate.model.dto.CalculateByRequestDTO;
import com.pitcrew.cleanhome.cleaner.calculate.model.dto.CalculateDTO;
import com.pitcrew.cleanhome.cleaner.calculate.model.dto.ProductSumDTO;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

public class CalculateService {
	
	private CalculateDAO calculateDAO;
	
	public CalculateService() {
		calculateDAO = new CalculateDAO();
	}

	public CalculateDTO selectCalculate(Map<String, Object> calculateMap) {
		
		SqlSession session = getSqlSession();
		
		CalculateDTO calculate = calculateDAO.selectCalculate(session, calculateMap);
		
		session.close();
		
		return calculate;
	}

	public ProductSumDTO CalculateProduct(Map<String, Object> calculateMap) {
		
		SqlSession session = getSqlSession();
		
		ProductSumDTO calculateProduct = calculateDAO.calculateProduct(session, calculateMap);
		
		session.close();
		
		return calculateProduct;
	}

	public List<CalculateByRequestDTO> selectCalculateDetail(int calNo) {
		
		SqlSession session = getSqlSession();
		
		List<CalculateByRequestDTO> calculateList = calculateDAO.selectCalculateDetail(session, calNo);
		
		session.close();
		
		return calculateList;
	}

}
