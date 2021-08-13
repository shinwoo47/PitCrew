package com.pitcrew.cleanhome.cleaner.request.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.cleaner.request.paging.SelectCriteria;


public class RequestDAO {

	public int selectTotalCount(SqlSession session, Map<String, String> searchMap) {
		
		return session.selectOne("RequestDAO.selectTotalCount", searchMap);
	}

	public List<RequestDTO> selectRequestList(SqlSession session, SelectCriteria selectCriteria) {
		
		return session.selectList("RequestDAO.selectRequestList", selectCriteria);
	}

	public int acceptRequest(SqlSession session, RequestDTO requestDto) {
		
		return session.update("RequestDAO.acceptRequest", requestDto);
	}

	public RequestDTO selectRequestDetail(SqlSession session, RequestDTO requestDto) {
				
		return session.selectOne("RequestDAO.selectRequestDetail", requestDto);
	}

	public String selectRequestStatus(SqlSession session, RequestDTO requestDto) {
		
		return session.selectOne("RequestDAO.selectRequestStatus", requestDto);
	}

	public int insertRequestStatusHistory(SqlSession session, RequestDTO requestDto) {
		
		return session.insert("RequestDAO.insertRequestStatusHistory", requestDto);
	}

	public int selectCleanerTotalCount(SqlSession session, Map<String, String> searchMap) {
		
		return session.selectOne("RequestDAO.selectCleanerTotalCount", searchMap);
	}

}
