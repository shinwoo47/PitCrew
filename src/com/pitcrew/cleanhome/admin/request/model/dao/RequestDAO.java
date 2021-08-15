package com.pitcrew.cleanhome.admin.request.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.common.paging.SelectAdminCriteria;
import com.pitcrew.cleanhome.common.paging.SelectCriteria;

public class RequestDAO {

	public int selectAllCount(SqlSession session, Map<String, String> searchMap) {
		
		return session.selectOne("RequestDAO.selectAllCount", searchMap);
	}

	public List<RequestDTO> selectReqList(SqlSession session, SelectAdminCriteria selectAdminCriteria) {
		
		return session.selectList("RequestDAO.selectReqList", selectAdminCriteria);
	}
	
	/* 의뢰 히스토리 조회 메소드 */
	public RequestDTO selectReqHistory(SqlSession session, int reqNo) {
		
		return session.selectOne("RequestDAO.selectReqHistory", reqNo);
	}

}
