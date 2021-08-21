package com.pitcrew.cleanhome.admin.pay.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.pay.model.dao.PayListDAO;
import com.pitcrew.cleanhome.admin.pay.model.dto.PayListDTO;

public class PayListService {
	
	private final PayListDAO payListDAO;
	
	public PayListService() {
		payListDAO = new PayListDAO();
	}

	public List<PayListDTO> selectAllPayList() {

		SqlSession session = getSqlSession();
		
		List<PayListDTO> PayList = payListDAO.selectAllPayList(session);
		
		session.close();
		
		return PayList;
	}

}
