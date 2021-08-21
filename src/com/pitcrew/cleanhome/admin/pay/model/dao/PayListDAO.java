package com.pitcrew.cleanhome.admin.pay.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.pay.model.dto.PayListDTO;

public class PayListDAO {

	public List<PayListDTO> selectAllPayList(SqlSession session) {

		return session.selectList("PayListDAO.selectAllPayList");
	}

}
