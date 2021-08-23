package com.pitcrew.cleanhome.admin.request.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.request.model.dao.RequestDAO;
import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.common.paging.SelectAdminCriteria;
import com.pitcrew.cleanhome.common.paging.SelectCriteria;

public class RequestService {

	private final RequestDAO requestDAO;

	public RequestService() {
		requestDAO = new RequestDAO();
	}


	/* 의뢰 페이징 처리용 전체 게시물 수 조회 메소드 */
	public int selectTotalCount(Map<String, String> searchMap) {

		SqlSession session = getSqlSession();
		int totalCount = requestDAO.selectAllCount(session, searchMap);

		session.close();

		return totalCount;
	}

	/* 의뢰 전체 조회용 메소드*/
	public List<RequestDTO> selectRequestList(SelectAdminCriteria selectAdminCriteria) {

		SqlSession session = getSqlSession();

		List<RequestDTO> requestList = requestDAO.selectReqList(session, selectAdminCriteria);

		session.close();

		return requestList;
	}

	/* 의뢰 히스토리 조회용 */
	public RequestDTO selectReqHistory(int reqNo) {

		SqlSession session = getSqlSession();

		RequestDTO reqDetailDTO = requestDAO.selectReqHistory(session, reqNo);

		session.close();

		return reqDetailDTO;
	}

}
