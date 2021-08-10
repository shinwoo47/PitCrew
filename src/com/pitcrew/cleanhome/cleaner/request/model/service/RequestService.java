package com.pitcrew.cleanhome.cleaner.request.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.cleaner.request.model.dao.RequestDAO;
import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.cleaner.request.paging.SelectCriteria;


public class RequestService {
	
	private final RequestDAO requestDAO;
	
	/* 생성자를 이용하여 객체를 생성하여 필드에 값을 넣는다. */
	public RequestService() {
		requestDAO = new RequestDAO();
	}

	public int selectTotalCount(Map<String, String> searchMap) {
		
		SqlSession session = getSqlSession();
		
		int totalCount = requestDAO.selectTotalCount(session, searchMap);
		
		session.close();
		
		return totalCount;
	}

	public List<RequestDTO> selectRequestList(SelectCriteria selectCriteria) {
		
		SqlSession session = getSqlSession();
		
		List<RequestDTO> requestList = requestDAO.selectRequestList(session, selectCriteria);
		
		session.close();
		
		return requestList;
	}

}
