package com.pitcrew.cleanhome.admin.request.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.request.model.dao.RequestDAO;
import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.common.paging.SelectCriteria;

public class RequestService {

	private final RequestDAO requestDAO;

	public RequestService() {
		requestDAO = new RequestDAO();
	}


	/* 의뢰 페이징 처리용 전체 게시물 수 조회 메소드 */
	public int selectTotalCount(Map<String, String> searchMap) {

		SqlSession session = getSqlSession();
		int totalCount = requestDAO.selectTotalCount(session, searchMap);

		session.close();

		return totalCount;
	}

	/* 의뢰 전체 조회용 메소드*/
	public List<RequestDTO> selectRequestList(SelectCriteria selectCriteria) {
		
		SqlSession session = getSqlSession();

		List<RequestDTO> requestList = requestDAO.selectRequestList(session, selectCriteria);

		System.out.println("서비스 리턴값 체크 " + requestList);
		session.close();

		return requestList;
	}

}
