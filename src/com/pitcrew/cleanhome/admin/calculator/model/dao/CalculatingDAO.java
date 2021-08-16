package com.pitcrew.cleanhome.admin.calculator.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.calculator.model.dto.CalculatingDTO;

public class CalculatingDAO {

	public List<CalculatingDTO> selectCalSetting(SqlSession session) {
		
		return session.selectList("CalculatingDAO.selectCalSetting");
	}

}
